package com.allianz.springlesson.controller;

import com.allianz.springlesson.database.repository.AddressEntityRepository;
import com.allianz.springlesson.model.AddressDTO;
import com.allianz.springlesson.model.requestDTO.AddressReuquestDTO;
import com.allianz.springlesson.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/add")
	public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressReuquestDTO addressDTO) {
		return ResponseEntity.ok(addressService.saveAddress(addressDTO));
	}
}
