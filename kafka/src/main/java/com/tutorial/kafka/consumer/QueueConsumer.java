package com.tutorial.kafka.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class QueueConsumer {

	private static final String MSG_TOPIC = "message";

	@KafkaListener(topics = MSG_TOPIC, groupId = "tutorial")
	public void listenStringMessage(String msg) {
		log.info("listenStringMessage " + msg);
	}
}
