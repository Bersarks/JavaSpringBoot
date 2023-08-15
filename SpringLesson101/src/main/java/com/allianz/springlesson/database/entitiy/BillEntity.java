package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table
@Entity
public class BillEntity extends BaseEntity {
	@Column(unique = true)
	private String billNumber;

	@Column
	private LocalDateTime billDate;

	@Column
	private BigDecimal totalPrice;

	@Column
	private BigDecimal taxRate;

	@Column
	private BigDecimal taxAmount;

	@Column
	private BigDecimal totalAmount;

	@OneToOne
	private OrderEntity order;
}

//Yarına repositoryleri dtoları mapperları ve serviceleri istiyoruz.