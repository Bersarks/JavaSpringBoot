package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@AttributeOverride(name = "uuid", column = @Column(name = "address_uuid"))
@Data
public class AddressEntity extends BaseEntity {
	@Column
	private String title;

	@Column(length = 500)
	private String address;

	/*OneToMany: LAZY
	ManyToOne: EAGER
	ManyToMany: LAZY
	OneToOne: EAGER*/
	//"Many" kısmı bulunduğumuz yer to "one" kısmı ise gideceğimiz yere işaret ediyor.
	// ManyToOne bir kişinin birden fazla adresi olabilir. OneToMany ile bunu belirtiyoruz.
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private PersonEntity person;

}
