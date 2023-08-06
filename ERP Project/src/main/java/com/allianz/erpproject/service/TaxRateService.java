package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.TaxRateEntity;
import com.allianz.erpproject.database.repository.TaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TaxRateService {

	@Autowired
	TaxRateRepository taxRateRepository;

	public double getTaxRate(UUID uuid) {
		TaxRateEntity taxRateEntity = getTaxRateEntity(uuid);
		if (taxRateEntity == null)
			return 0;
		else
			return taxRateEntity.getRate();
	}

	public TaxRateEntity getTaxRateEntity(UUID uuid) {
		return taxRateRepository.findByUuid(uuid).orElse(null);
	}

	public List<TaxRateEntity> getTaxRateByName(String name) {
		return taxRateRepository.findAllByNameContainsIgnoreCase(name);
	}

	public List<TaxRateEntity> getAllTaxRate() {
		return taxRateRepository.findAll();
	}

	public TaxRateEntity addTaxRate(TaxRateEntity taxRateEntity) {
		TaxRateEntity taxRateEntity1 = new TaxRateEntity();
		taxRateEntity1.setRate(taxRateEntity.getRate());
		taxRateEntity1.setName(taxRateEntity.getName());
		return taxRateRepository.save(taxRateEntity1);
	}
	@Transactional
	public TaxRateEntity updateTaxRate(TaxRateEntity taxRateEntity, UUID uuid) {
		TaxRateEntity taxRateEntity1 = getTaxRateEntity(uuid);
		if (taxRateEntity1 == null)
			return null;
		taxRateEntity1.setRate(taxRateEntity.getRate());
		return taxRateRepository.save(taxRateEntity1);
	}
	@Transactional
	public boolean deleteTaxRate(UUID uuid) {
		TaxRateEntity taxRateEntity = getTaxRateEntity(uuid);
		if (taxRateEntity != null) {
			taxRateRepository.deleteByUuid(uuid);
			return true;
		} else
			return false;
	}
}
