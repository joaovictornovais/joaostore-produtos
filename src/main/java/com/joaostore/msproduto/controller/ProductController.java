package com.joaostore.msproduto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaostore.msproduto.dto.ProductDTO;
import com.joaostore.msproduto.model.Product;
import com.joaostore.msproduto.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
		return ResponseEntity.ok(productService.save(new Product(productDTO)));
	}

}
