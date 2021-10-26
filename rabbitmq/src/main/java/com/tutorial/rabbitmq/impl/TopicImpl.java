package com.tutorial.rabbitmq.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicImpl {

	private final String exchange = "topic.exchange";

	@Autowired
	RabbitTemplate rabbitTemplate;

	public void sendStringSmallQueue(String value) {
		rabbitTemplate.convertAndSend(exchange, "topic.string.small", value);
	}

	public void sendStringLargeQueue(String value) {
		rabbitTemplate.convertAndSend(exchange, "topic.string.large", value);
	}

	public void sendStringLargeQueue(String value, String key) {
		rabbitTemplate.convertAndSend(exchange, "topic.string." + key, value);
	}

}
