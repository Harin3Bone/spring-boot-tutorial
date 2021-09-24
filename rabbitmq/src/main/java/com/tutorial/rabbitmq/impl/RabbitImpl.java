package com.tutorial.rabbitmq.impl;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.rabbitmq.entity.TransactionEntity;
import com.tutorial.rabbitmq.service.RabbitService;

@Service
public class RabbitImpl implements RabbitService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void publishWorkerValueQueue(String value) {
		rabbitTemplate.convertAndSend("primitive-string-queue", value);
	}

	@Override
	public void publishWorkerValueQueue(int value) {
		rabbitTemplate.convertAndSend("primitive-number-queue", value);
	}

	@Override
	public void publishWorkerReferenceQueue(Map<String, Object> value) {
		rabbitTemplate.convertAndSend("non-primitive-reference-queue", value);
	}

	@Override
	public void publishWorkerObjectQueue(TransactionEntity value) {
		rabbitTemplate.convertAndSend("non-primitive-object-queue", value);
	}
}
