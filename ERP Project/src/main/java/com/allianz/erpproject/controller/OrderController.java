package com.allianz.erpproject.controller;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.entity.OrderEntity;
import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/add/basket/{productUuid}/{customerUuid}/{quantity}")
	public ResponseEntity<OrderEntity> addItemToOrder(@PathVariable UUID productUuid,
														  @PathVariable UUID customerUuid, @PathVariable int quantity) {
		OrderEntity orderEntity = (orderService.addItemToOrder(productUuid, customerUuid, quantity));
		if (orderEntity == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderEntity);
	}

	@PostMapping("/create-order/{productUuid}/{customerUuid}/{quantity}")
	public ResponseEntity<OrderEntity> createOrder(@PathVariable UUID productUuid,
														  @PathVariable UUID customerUuid, @PathVariable int quantity) {
		OrderEntity orderEntity = orderService.createNewOrder(productUuid, customerUuid, quantity);
		if (orderEntity == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderEntity);
	}

	@PostMapping("/status/{orderUuid}/{status}")
	public ResponseEntity<OrderEntity> changeOrderStatus(@PathVariable UUID orderUuid, @PathVariable int status) {
		OrderEntity orderEntity = orderService.setStatusToOrder(orderUuid, status);
		if (orderEntity == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderEntity);
	}

	@DeleteMapping("/delete/{customerUuid}/{orderUuid}")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID customerUuid, @PathVariable UUID orderUuid) {
		boolean status = orderService.deleteOrder(customerUuid, orderUuid);
		if (!status) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(status);
	}
}
