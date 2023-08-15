package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PersonRequestDTO extends BaseDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String tc;
}
