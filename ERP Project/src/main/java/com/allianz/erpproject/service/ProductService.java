package com.allianz.erpproject.service;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<ProductEntity> getAllProduct() {
		return productRepository.findAll();
	}
	public List<ProductEntity> getProduct(String key) {
		return productRepository.findAllByNameStartingWith(key);
	}

	public List<ProductEntity> getProductContains(String key) {
		return productRepository.findAllByNameContainsIgnoreCase(key);
	}

	public ProductEntity updateProduct(ProductEntity productEntity, UUID uuid) {
		ProductEntity productEntity1 = getProductByUuid(uuid);
		if (productEntity1 == null)
			return null;
		productEntity1.setName(productEntity.getName());
		productEntity1.setPrice(productEntity.getPrice());
		productEntity1.setTaxIncluded(productEntity.getTaxIncluded());
		productEntity1.setStock(productEntity.getStock());
		return productRepository.save(productEntity1);
	}

	public ProductEntity getProductByUuid(UUID uuid) {
		Optional<ProductEntity> optionalProductEntity = productRepository.findByUuid(uuid);
		return optionalProductEntity.orElse(null);
	}

	@Transactional
	public boolean deleteProductByUuid(UUID uuid) {
		ProductEntity productEntity = getProductByUuid(uuid);
		if (productEntity != null) {
			productRepository.deleteByUuid(uuid);
			return true;
		} else
			return false;
	}

	@Transactional
	public ProductEntity addProduct(ProductEntity productEntity) {

		return productRepository.save(productEntity);
	}
}
