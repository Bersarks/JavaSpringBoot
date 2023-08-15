package com.allianz.springlesson.model.requestDTO;

import com.allianz.springlesson.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {
	private String name;
	private String surname;
	private int birthYear;
	private String tc;
}
