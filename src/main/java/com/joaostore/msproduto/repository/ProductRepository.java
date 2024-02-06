package com.joaostore.msproduto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.joaostore.msproduto.model.Product;

@Repository
public class ProductRepository {
	
	@Autowired 
	private DynamoDBMapper dynamoDBMapper;
	
	public Product save(Product product) {
		dynamoDBMapper.save(product);
		return product;
	}
	
}
