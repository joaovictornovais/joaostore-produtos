package com.joaostore.msproduto.service;

import org.springframework.stereotype.Service;

import com.joaostore.msproduto.model.Product;
import com.joaostore.msproduto.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}

}
