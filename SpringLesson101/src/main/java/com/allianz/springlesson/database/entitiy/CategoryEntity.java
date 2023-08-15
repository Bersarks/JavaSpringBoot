package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table
@Entity
public class CategoryEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_category",
			joinColumns = @JoinColumn(name = "category_id"), //birleştirilen yeni oluşturulan tabloda category_id sütunu oluşturulacak.
			inverseJoinColumns = @JoinColumn(name = "product_id")) //birleştirilen yeni oluşturulan tabloda product_id sütunu oluşturulacak.
	private Set<ProductEntity> productEntityList;
}
