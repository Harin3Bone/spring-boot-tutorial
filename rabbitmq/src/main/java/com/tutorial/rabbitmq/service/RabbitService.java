package com.tutorial.rabbitmq.service;

import java.util.Map;

import com.tutorial.rabbitmq.entity.TransactionEntity;

public interface RabbitService {

	void sendStringQueue(String value);
	
	void sendNumberQueue(int value);
	
	void sendReferenceQueue(Map<String,Object> value);
	
	void sendObjectQueue(TransactionEntity value);
}
