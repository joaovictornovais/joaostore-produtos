package com.joaostore.msproduto.service.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.joaostore.msproduto.model.Product;

@Service
public class SqsProducer {
	
	private final AmazonSQS amazonSQSClient;
	
	@Value("${app.config.message.queue.topic}")
	private String queueUrl;
	
	public SqsProducer(AmazonSQS amazonSQSClient) {
		this.amazonSQSClient = amazonSQSClient;
	}
	
	public void addToCart(Product product) {
		try {
			amazonSQSClient.sendMessage(queueUrl, 
					product.getProduct_id() + 
					product.getName() + 
					product.getPrice() + 
					product.getDescription() + 
					product.getQuantity());
			
		} catch (QueueDoesNotExistException e) {
			System.out.println("Erro ao adicionar compra");
		}
	}

}
