package com.allianz.erpproject.database.entity;

import com.allianz.erpproject.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "receipt")
@AttributeOverride(name = "uuid", column = @Column(name = "receipt_uuid"))
@Data
public class ReceiptEntity extends BaseEntity {
	@JsonIgnore
	@OneToOne(mappedBy = "receipt")
	private OrderEntity order;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private double price;
}
