package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table
@Entity
public class CustomerEntity extends BaseEntity{
	@OneToOne
	private PersonEntity personEntity;
	@Column
	private Boolean isCorporate;
	@Column
	private String companyName;
	@Column
	private String taxNumber;
	@Column
	private String taxOffice;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderEntity> orderList;

}
