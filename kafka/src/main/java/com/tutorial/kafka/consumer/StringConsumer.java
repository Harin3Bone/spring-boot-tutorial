package com.tutorial.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class StringConsumer {
	
	private static final String MSG_DIR_TOPIC = "message_dir";
	private static final String MSG_CON_TOPIC = "message_con";

	@KafkaListener(topics = MSG_DIR_TOPIC, groupId = "tutorial")
	public void listenStringMessage(String msg) {
		log.info("listenStringMessage " + msg);
	}
	
	@KafkaListener(topics = MSG_CON_TOPIC, groupId = "tutorial")
	public void listenStringMessage(ConsumerRecord<String, String> msg) {
		String newMsg = msg.value();
		log.info("listenStringMessage " + newMsg);
	}
}
