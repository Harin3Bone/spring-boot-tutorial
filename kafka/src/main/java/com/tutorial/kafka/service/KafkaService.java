package com.tutorial.kafka.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaService {

	private static final String OBJ_TOPIC = "object";

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public void produceStringMessage(String topic, String msg) {
		log.info("produceStringMessage message= " + msg);
		kafkaTemplate.send(topic, msg);
	}
	
	public void sendObjectMessage(Map<String,Object> msg) {
		log.info("sendObjectMessage message= " + msg);
		kafkaTemplate.send(OBJ_TOPIC, msg.toString());
	}
}
