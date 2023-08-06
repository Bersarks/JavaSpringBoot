package com.allianz.erpproject.controller;

import com.allianz.erpproject.database.entity.TaxRateEntity;
import com.allianz.erpproject.service.TaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/taxrate")
public class TaxRateController {
	@Autowired
	TaxRateService taxRateService;

	@GetMapping("/get-all")
	public ResponseEntity<List<TaxRateEntity>> getAllTaxRateEntity() {
		return ResponseEntity.ok(taxRateService.getAllTaxRate());
	}

	@GetMapping("/get/{key}")
	public ResponseEntity<List<TaxRateEntity>> getTaxRateEntity(@PathVariable String key) {
		return ResponseEntity.ok(taxRateService.getTaxRateByName(key));
	}

	@GetMapping("/get-by-uuid/{uuid}")
	public ResponseEntity<Double> getTaxRateEntity(@PathVariable UUID uuid) {
		return ResponseEntity.ok(taxRateService.getTaxRate(uuid));
	}

	@PostMapping("/add")
	public ResponseEntity<TaxRateEntity> addTaxRate(@RequestBody TaxRateEntity taxRateEntity) {
		return ResponseEntity.ok(taxRateService.addTaxRate(taxRateEntity));
	}

	@PutMapping("/update/{uuid}")
	public ResponseEntity<TaxRateEntity> updateTaxRate(@PathVariable UUID uuid) {
		TaxRateEntity taxRateEntity = taxRateService.getTaxRateEntity(uuid);
		if (taxRateEntity == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(taxRateService.updateTaxRate(taxRateEntity, uuid));
	}

	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<Boolean> deleteTaxRate(@PathVariable UUID uuid) {
		return ResponseEntity.ok(taxRateService.deleteTaxRate(uuid));
	}
}
