package com.allianz.springlesson.model;

import com.allianz.springlesson.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {
	private String title;
	private String address;
	//private PersonDTO personDTO; //adresleri persondan çekeceğimiz için personDTO'ya gerek yok.
}
