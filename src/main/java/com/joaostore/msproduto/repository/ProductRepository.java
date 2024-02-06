package com.joaostore.msproduto.repository;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.joaostore.msproduto.model.Product;

@Repository
public class ProductRepository {
	
	private DynamoDBMapper dynamoDBMapper;
	
	public ProductRepository(DynamoDBMapper dynamoDBMapper) {
		this.dynamoDBMapper = dynamoDBMapper;
	}
	
	public Product save(Product product) {
		dynamoDBMapper.save(product);
		return product;
	}
	
}
