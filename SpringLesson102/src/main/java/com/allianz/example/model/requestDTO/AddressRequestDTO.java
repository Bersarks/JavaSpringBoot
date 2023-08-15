package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {
    private String title;
    private String address;
}
