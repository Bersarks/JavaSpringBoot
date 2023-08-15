package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.model.enums.ColorEnum;
import com.allianz.springlesson.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String code;
	@Column
	@Enumerated(EnumType.STRING)
	private ColorEnum color;
	@Column
	private BigDecimal sellPrice;
	@Column
	private BigDecimal buyPrice;
	@Column
	private Integer stock;
	@ManyToMany(mappedBy = "productEntityList", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CategoryEntity> categoryEntityList;
	@ManyToOne(fetch = FetchType.EAGER)
	private TaxEntity taxEntity;
}
