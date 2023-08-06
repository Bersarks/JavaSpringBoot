package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_item")
@AttributeOverride(name = "uuid", column = @Column(name = "order_item_uuid"))
@Data
public class OrderItemEntity extends BaseEntity {
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	@JsonIgnore
	@ManyToOne
	private ProductEntity product;

	private int quantity;
	private double price;
}
