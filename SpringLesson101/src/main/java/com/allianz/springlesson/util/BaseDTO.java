package com.allianz.springlesson.util;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDTO {

	private Long id;

	private UUID uuid;

	private Date createdDate;

	private Date updatedDate;
}
