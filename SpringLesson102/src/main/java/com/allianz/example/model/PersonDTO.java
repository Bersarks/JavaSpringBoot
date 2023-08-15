package com.allianz.example.model;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO extends BaseDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private List<AddressDTO> addressList;

}
