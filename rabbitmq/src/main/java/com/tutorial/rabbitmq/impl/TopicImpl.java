package com.tutorial.rabbitmq.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicImpl {

	private final String exchange = "topic-exchange";

	@Autowired
	AmqpTemplate rabbitTemplate;

	public void sendStringSmallQueue(String value) {
		System.out.println("Small IN");
		rabbitTemplate.convertAndSend(exchange, "topic.string.small", value);
		System.out.println("Small OUT");
	}

	public void sendStringLargeQueue(String value) {
		System.out.println("Large IN");
		rabbitTemplate.convertAndSend(exchange, "topic.string.large", value);
		System.out.println("Large OUT");
	}

}
