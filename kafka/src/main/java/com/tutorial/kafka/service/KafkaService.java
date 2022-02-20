package com.tutorial.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaService {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public void produceStringMessage(String topic, String msg) {
		log.info("produceStringMessage message= " + msg);
		kafkaTemplate.send(topic, msg);
	}
}
