package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Data
public class CustomerEntity extends BaseEntity {

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String tc;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<OrderEntity> orders = new ArrayList<>();
}
