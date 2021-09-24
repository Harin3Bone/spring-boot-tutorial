package com.tutorial.rabbitmq.service;

import java.util.Map;

import com.tutorial.rabbitmq.entity.TransactionEntity;

public interface RabbitService {

	void publishWorkerValueQueue(String value);
	
	void publishWorkerValueQueue(int value);
	
	void publishWorkerReferenceQueue(Map<String,Object> value);
	
	void publishWorkerObjectQueue(TransactionEntity value);
}
