package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "tax_rate")
@Entity
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "tax_rate_uuid"))
public class TaxRateEntity extends BaseEntity {
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private double rate;
}
