package com.tutorial.rabbitmq.impl;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.rabbitmq.entity.TransactionEntity;
import com.tutorial.rabbitmq.service.RabbitService;

@Service
public class TopicImpl implements RabbitService {

	private final String exchange = "topic-exchange";

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void sendStringQueue(String value) {
		rabbitTemplate.convertAndSend(exchange, "topic-string-queue", value);
	}

	@Override
	public void sendNumberQueue(int value) {
		rabbitTemplate.convertAndSend(exchange, "topic-number-queue", value);
	}

	@Override
	public void sendReferenceQueue(Map<String, Object> value) {
		rabbitTemplate.convertAndSend(exchange, "topic-reference-queue", value);
	}

	@Override
	public void sendObjectQueue(TransactionEntity value) {
		rabbitTemplate.convertAndSend(exchange, "topic-object-queue", value);
	}
	
	public void sendMatchQueue(String value) {
		rabbitTemplate.convertAndSend(exchange, "matchtopic-string-queue", value);
	}

}
