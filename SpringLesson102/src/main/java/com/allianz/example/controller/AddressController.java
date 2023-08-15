package com.allianz.example.controller;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("get-all")
    public ResponseEntity<List<AddressEntity>> getAll(){
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressRequestDTO addressRequestDTO){
        return new ResponseEntity<>(addressService.save(addressRequestDTO), HttpStatus.OK);
    }
}
