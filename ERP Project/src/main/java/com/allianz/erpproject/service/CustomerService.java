package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;


	public List<CustomerEntity> getAllCustomer() {
		return customerRepository.findAll();
	}
	@Transactional
	public CustomerEntity updateCustomer(CustomerEntity customerEntity, UUID uuid) {
		CustomerEntity customerEntity1 = getCustomerByUuid(uuid);
		if (customerEntity1 == null)
			return null;
		else {
			customerEntity1.setName(customerEntity.getName());
			customerEntity1.setSurname(customerEntity.getSurname());
			customerEntity1.setTc(customerEntity.getTc());
			return customerRepository.save(customerEntity1);
		}
	}
	public CustomerEntity updateCustomerOrder(CustomerEntity customerEntity) {
		return customerRepository.save(customerEntity);
	}
	@Transactional
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {
		return customerRepository.save(customerEntity);
	}

	public List<CustomerEntity> getCustomerByName(String name) {
		return customerRepository.findAllByNameStartingWith(name);
	}

	public List<CustomerEntity> searchCustomerByNameSurname(String name, String surname) {
		return customerRepository.findAllByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(name, surname);
	}

	public CustomerEntity getCustomerByUuid(UUID uuid) {
		Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByUuid(uuid);
		return optionalCustomerEntity.orElse(null);
	}

	@Transactional
	public boolean deleteUserByUuid(UUID uuid) {
		Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findByUuid(uuid);
		if (optionalCustomerEntity.isPresent()) {
			customerRepository.deleteByUuid(uuid);
			return true;
		} else
			return false;
	}
}
