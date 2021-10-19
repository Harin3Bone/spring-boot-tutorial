package com.tutorial.rabbitmq.impl;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.rabbitmq.entity.TransactionEntity;
import com.tutorial.rabbitmq.service.RabbitService;

@Service
public class WorkerImpl implements RabbitService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void sendStringQueue(String value) {
		rabbitTemplate.convertAndSend("worker-string-queue", value);
	}

	@Override
	public void sendNumberQueue(int value) {
		rabbitTemplate.convertAndSend("worker-number-queue", value);
	}

	@Override
	public void sendReferenceQueue(Map<String, Object> value) {
		rabbitTemplate.convertAndSend("worker-reference-queue", value);
	}

	@Override
	public void sendObjectQueue(TransactionEntity value) {
		rabbitTemplate.convertAndSend("worker-object-queue", value);
	}
}
