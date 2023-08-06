package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.OrderItemEntity;
import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.database.entity.TaxRateEntity;
import com.allianz.erpproject.database.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	TaxRateService taxRateService;

	public OrderItemEntity createOrderItem(ProductEntity productEntity, int quantity) {
		List<TaxRateEntity> taxRateEntityList;
		OrderItemEntity orderItemEntity = new OrderItemEntity();
		orderItemEntity.setProduct(productEntity);
		orderItemEntity.setQuantity(quantity);
		if (!productEntity.getTaxIncluded()){
			taxRateEntityList = taxRateService.getAllTaxRate();
			orderItemEntity.setPrice(productEntity.getPrice() * quantity * (1 + taxRateEntityList.get(0).getRate()));
		} else
			orderItemEntity.setPrice(productEntity.getPrice() * quantity);
		return orderItemEntity;
	}
	@Transactional
	public void deleteOrderItems(List<OrderItemEntity> orderItemEntityList) {
		orderItemRepository.deleteAll(orderItemEntityList);
	}
}
