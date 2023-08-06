package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.entity.OrderEntity;
import com.allianz.erpproject.database.entity.OrderItemEntity;
import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.database.enums.StatusEnum;
import com.allianz.erpproject.database.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
	@Autowired
	CustomerService customerService;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductService productService;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ReceiptService receiptService;


	public OrderEntity createOrder(CustomerEntity customerEntity) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setName(customerEntity.getName() + " " + customerEntity.getSurname() + " Order");
		orderEntity.setDescription(customerEntity.getName() + " " + customerEntity.getSurname() + " Order");
		orderEntity.setCustomer(customerEntity);
		return orderEntity;
	}

	public OrderEntity getActiveOrder(CustomerEntity customerEntity) {
		for (OrderEntity orderEntity : customerEntity.getOrders()) {
			if (orderEntity.getStatus() == StatusEnum.PENDING) {
				return orderEntity;
			}
		}
		return null;
	}

	public void setOrderPrice(OrderEntity orderEntity) {
		double price = 0;
		for (OrderItemEntity orderItemEntity : orderEntity.getOrderItems()) {
			price += orderItemEntity.getPrice();
		}
		orderEntity.setPrice(price);
	}

	public boolean checkActiveOrder(CustomerEntity customerEntity) {
		for (OrderEntity orderEntity : customerEntity.getOrders()) {
			if (orderEntity.getStatus() == StatusEnum.PENDING) {
				return true;
			}
		}
		return false;
	}

	public List<OrderItemEntity> getOrderItems(UUID orderUuid) {
		OrderEntity orderEntity = orderRepository.findByUuid(orderUuid);
		return orderEntity.getOrderItems();
	}

	public OrderEntity addItemToOrder(UUID productUuid, UUID customerUuid, int quantity) {
		CustomerEntity customerEntity = customerService.getCustomerByUuid(customerUuid);
		ProductEntity productEntity = productService.getProductByUuid(productUuid);
		if (customerEntity == null) {
			return null;
		}
		if (productEntity == null) {
			return null;
		}
		OrderEntity orderEntity = getActiveOrder(customerEntity);
		OrderItemEntity orderItemEntity = orderItemService.createOrderItem(productEntity, quantity);
		productService.updateProductStock(productEntity, quantity);
		orderEntity.getOrderItems().add(orderItemEntity);
		orderItemEntity.setOrder(orderEntity);
		setOrderPrice(orderEntity);
		return orderRepository.save(orderEntity);
	}

	public OrderEntity createNewOrder(UUID productUuid, UUID customerUuid, int quantity) {
		CustomerEntity customerEntity = customerService.getCustomerByUuid(customerUuid);
		ProductEntity productEntity = productService.getProductByUuid(productUuid);
		if (customerEntity == null)
			return null;
		if (productEntity == null)
			return null;
		if (checkActiveOrder(customerEntity))
			return null;
		OrderEntity orderEntity = createOrder(customerEntity);
		OrderItemEntity orderItemEntity = orderItemService.createOrderItem(productEntity, quantity);
		productService.updateProductStock(productEntity, quantity);
		orderItemEntity.setOrder(orderEntity);
		orderEntity.getOrderItems().add(orderItemEntity);
		setOrderPrice(orderEntity);
		customerEntity.getOrders().add(orderEntity);
		return orderRepository.save(orderEntity);
	}

	public OrderEntity setStatusToOrder(UUID uuid, int status) {
		OrderEntity orderEntity = orderRepository.findByUuid(uuid);
		if (orderEntity == null || status < 0 || status > 3) {
			return null;
		}
		orderEntity.setStatus(StatusEnum.values()[status - 1]);
		receiptService.createReceipt(orderEntity);
		return orderRepository.save(orderEntity);
	}

	@Transactional
	public Boolean deleteOrder(UUID customerUuid, UUID orderUuid) {
		CustomerEntity customerEntity = customerService.getCustomerByUuid(customerUuid);
		if (customerEntity == null) {
			return false;
		}
		OrderEntity orderEntity = orderRepository.findByUuid(orderUuid);
		if (orderEntity == null || orderEntity.getStatus() == StatusEnum.APPROVED
				|| orderEntity.getStatus() == StatusEnum.REJECTED) {
			return false;
		}
		customerEntity.getOrders().remove(orderEntity);
		for (OrderItemEntity orderItemEntity : orderEntity.getOrderItems()) {
			productService.updateProductStock(orderItemEntity.getProduct(), -orderItemEntity.getQuantity());
		}
		orderItemService.deleteOrderItems(orderEntity.getOrderItems());
		orderRepository.deleteByUuid(orderUuid);
		return true;
	}
}
