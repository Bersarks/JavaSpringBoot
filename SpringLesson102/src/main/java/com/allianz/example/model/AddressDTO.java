package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;
//    private PersonDTO personDTO;
}
