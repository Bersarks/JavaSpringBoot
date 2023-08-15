package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table
@Entity
public class OrderItemEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@Column
	private ProductEntity product;
	@Column
	private Integer quantity;
	@Column
	private BigDecimal sellPrice;
}
