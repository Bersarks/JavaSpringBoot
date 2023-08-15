package com.allianz.springlesson.model.requestDTO;

import com.allianz.springlesson.util.BaseDTO;
import lombok.Data;

@Data
public class AddressReuquestDTO extends BaseDTO {
	private String title;
	private String address;
}
