package com.allianz.erpproject.controller;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.entity.OrderItemEntity;
import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/search-by-name/{key}")
	public ResponseEntity<List<ProductEntity>> getProduct(@PathVariable String key){
		return new ResponseEntity<>(productService.getProduct(key), HttpStatus.OK);
	}
	@GetMapping("/search/{key}")
	public ResponseEntity<List<ProductEntity>> getProductContains(@PathVariable String key){
		return new ResponseEntity<>(productService.getProductContains(key), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity productEntity){
		return new ResponseEntity<>(productService.addProduct(productEntity), HttpStatus.OK);
	}

	@PutMapping("/update/{uuid}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable UUID uuid, @RequestBody ProductEntity productEntity) {
		ProductEntity productEntity1 = productService.getProductByUuid(uuid);
		if (productEntity1 == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(productService.updateProduct(productEntity, uuid));
	}
	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<Boolean> deleteProductByUuid(@PathVariable UUID uuid) {
		return ResponseEntity.ok(productService.deleteProductByUuid(uuid));
	}
}
