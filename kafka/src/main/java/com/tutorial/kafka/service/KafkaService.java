package com.tutorial.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaService {

	private static final String MSG_TOPIC = "message";

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public void produceStringMessage(String msg) {
		log.info("produceStringMessage message= " + msg);
		kafkaTemplate.send(MSG_TOPIC, msg);
	}
}
