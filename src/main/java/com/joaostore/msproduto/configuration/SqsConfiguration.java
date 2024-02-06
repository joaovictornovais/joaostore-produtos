package com.joaostore.msproduto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class SqsConfiguration {
	
	@Bean
    public AmazonSQS amazonSQSClient() {
        return AmazonSQSClientBuilder.standard()
        		.withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }

}
