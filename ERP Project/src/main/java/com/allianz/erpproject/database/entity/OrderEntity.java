package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.database.enums.StatusEnum;
import com.allianz.erpproject.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
@Data
public class OrderEntity extends BaseEntity {
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderItemEntity> orderItems = new ArrayList<>();

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "receipt_id")
	private ReceiptEntity receipt;

	@Column
	private String name;
	@Column
	private String description;
	@Column
	@Enumerated(EnumType.STRING)
	private StatusEnum status = StatusEnum.PENDING;
	@Column
	private double price;
}
