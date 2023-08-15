package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class SellerEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String tc;
	@Column
	private String email;
	@Column
	private String shopName;
	@Column
	private String taxNumber;
	@Column
	private String taxOffice;
}
