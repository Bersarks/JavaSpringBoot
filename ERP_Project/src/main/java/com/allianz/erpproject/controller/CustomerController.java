package com.allianz.erpproject.controller;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/search")
	public ResponseEntity<List<CustomerEntity>> getAllCustomer() {
		return ResponseEntity.ok(customerService.getAllCustomer());
	}

	@GetMapping("/search/{key}")
	public ResponseEntity<List<CustomerEntity>> getCustomerByName(@PathVariable String key) {
		return ResponseEntity.ok(customerService.getCustomerByName(key));
	}
	@GetMapping("/search/{name}/{surname}")
	public ResponseEntity<List<CustomerEntity>> searchCustomerByNameSurname(@PathVariable String name, @PathVariable String surname) {
		return ResponseEntity.ok(customerService.searchCustomerByNameSurname(name, surname));
	}

	@GetMapping("/search-by-uuid/{uuid}")
	public ResponseEntity<CustomerEntity> getCustomerByUuid(@PathVariable UUID uuid) {
		return ResponseEntity.ok(customerService.getCustomerByUuid(uuid));
	}

	@PostMapping("/add")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customerEntity) {
		return ResponseEntity.ok(customerService.addCustomer(customerEntity));
	}

	@PutMapping("/update/{uuid}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable UUID uuid, @RequestBody CustomerEntity customerEntity) {
		CustomerEntity customerEntity1 = customerService.getCustomerByUuid(uuid);
		if (customerEntity1 == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(customerService.updateCustomer(customerEntity, uuid));
	}
	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<Boolean> deleteCustomerByUuid(@PathVariable UUID uuid) {
		return ResponseEntity.ok(customerService.deleteUserByUuid(uuid));
	}
}
