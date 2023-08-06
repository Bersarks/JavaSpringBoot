package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Table(name = "product")
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
public class ProductEntity extends BaseEntity {
	@Column(nullable = false, unique = true)
	private String name;
	@Column
	String description;
	@Column(nullable = false)
	private double price;
	@Column
	private boolean taxIncluded;
	@Column(nullable = false)
	private int stock;

	public boolean getTaxIncluded() {
		return taxIncluded;
	}
}
