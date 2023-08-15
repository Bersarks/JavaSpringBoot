package com.allianz.springlesson.model;

import com.allianz.springlesson.util.BaseDTO;
import lombok.Data;

import java.util.List;

/*ihtiyaca göre DTO lar oluşturulur aynı entity içi n bir çok dto oluşturulabilir istediğimiz verileri de alabiliriz ekstra şeyler de eklenebilir*/
@Data
public class PersonDTO extends BaseDTO {

	private String name;

	private String surname;

	private int birthYear;

	private String  tc;

	private List<AddressDTO> address;
}
