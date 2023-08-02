package com.allianz.springlesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
//@Getter // sadece Getter oluşturuyor sadece setter için yine aynı şekilde @Setter. @NoArgsConstructor ise parametresiz constructor oluşturuyor.
public class PersonDTO {
	private String name;
	private String surname;
	private int birthYear;
	private String tc;
	private UUID uuid;

	public PersonDTO() {
		this.uuid = UUID.randomUUID();
	}
}
