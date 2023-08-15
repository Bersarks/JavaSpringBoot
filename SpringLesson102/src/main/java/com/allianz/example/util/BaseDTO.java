package com.allianz.example.util;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class BaseDTO {
    private Long id;
    private UUID uuid;
    private Date creationDate;
    private Date updateDate;

}
