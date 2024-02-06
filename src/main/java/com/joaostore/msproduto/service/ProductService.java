package com.joaostore.msproduto.service;

import org.springframework.stereotype.Service;

import com.joaostore.msproduto.model.Product;
import com.joaostore.msproduto.repository.ProductRepository;
import com.joaostore.msproduto.service.aws.SqsProducer;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final SqsProducer sqsProducer;
	
	public ProductService(ProductRepository productRepository, SqsProducer sqsProducer) {
		this.productRepository = productRepository;
		this.sqsProducer = sqsProducer;
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public void addToCart(Product product) {
		sqsProducer.addToCart(product);
	}

}
