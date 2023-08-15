package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Table
@Entity
public class TaxEntity extends BaseEntity {
	@Column
	private String name;
	@Column(unique = true)
	private String code;
	@Column
	private BigDecimal rate;
}
