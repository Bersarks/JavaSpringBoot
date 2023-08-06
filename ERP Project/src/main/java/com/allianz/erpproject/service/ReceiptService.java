package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.OrderEntity;
import com.allianz.erpproject.database.entity.OrderItemEntity;
import com.allianz.erpproject.database.entity.ReceiptEntity;
import com.allianz.erpproject.database.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
	@Autowired
	ReceiptRepository receiptRepository;

	public void createReceipt(OrderEntity orderEntity) {
		ReceiptEntity receiptEntity = new ReceiptEntity();
		receiptEntity.setName(orderEntity.getName() + " Receipt");
		fillDescription(receiptEntity, orderEntity);
		receiptEntity.setPrice(orderEntity.getPrice());
		receiptEntity.setOrder(orderEntity);
		orderEntity.setReceipt(receiptEntity);
		receiptRepository.save(receiptEntity);
	}

	public void fillDescription(ReceiptEntity receiptEntity, OrderEntity orderEntity) {
		for (OrderItemEntity orderItemEntity : orderEntity.getOrderItems()) {
			receiptEntity.setDescription(receiptEntity.getDescription() + orderItemEntity.getProduct().getName() + " "
					+ orderItemEntity.getProduct().getPrice() + " TL\n");
		}
	}
}
