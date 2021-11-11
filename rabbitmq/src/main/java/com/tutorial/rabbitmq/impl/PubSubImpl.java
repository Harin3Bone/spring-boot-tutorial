package com.tutorial.rabbitmq.impl;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.rabbitmq.entity.TransactionEntity;
import com.tutorial.rabbitmq.service.RabbitService;

public class PubSubImpl implements RabbitService {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Override
	public void sendStringQueue(String value) {
		

	}

	@Override
	public void sendNumberQueue(int value) {
		
		
	}

	@Override
	public void sendReferenceQueue(Map<String, Object> value) {
		
		
	}

	@Override
	public void sendObjectQueue(TransactionEntity value) {
		
		
	}

}
