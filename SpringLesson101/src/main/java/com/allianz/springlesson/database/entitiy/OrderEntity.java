package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.model.enums.OrderStatusEnum;
import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class OrderEntity extends BaseEntity {
	@Column
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;

	@OneToMany()
	private List<OrderItemEntity> orderItemList;

	@Column
	private BigDecimal totalPrice;

	@OneToOne
	private BillEntity bill;
}
