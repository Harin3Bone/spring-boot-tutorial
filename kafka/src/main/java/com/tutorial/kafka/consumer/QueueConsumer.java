package com.tutorial.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class QueueConsumer {
	
	private static final String MSG_TOPIC = "message";
	private static final String MSG_CON_TOPIC = "message_con";
	private static final String OBJ_TOPIC = "object";

	@KafkaListener(topics = MSG_TOPIC, groupId = "tutorial")
	public void listenStringMessage(String msg) {
		log.info("listenStringMessage " + msg);
	}
	
	@KafkaListener(topics = MSG_CON_TOPIC, groupId = "tutorial")
	public void listenStringMessage(ConsumerRecord<String, String> msg) {
		String newMsg = msg.value();
		log.info("listenStringMessage " + newMsg);
	}
	
	@KafkaListener(topics = OBJ_TOPIC, groupId = "tutorial")
	public void listenObjectMessage(String msg) {
		log.info("listenObjectMessage " + msg);
		
	}
}
