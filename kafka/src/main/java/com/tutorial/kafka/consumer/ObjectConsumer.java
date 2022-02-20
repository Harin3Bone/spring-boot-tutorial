package com.tutorial.kafka.consumer;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class ObjectConsumer {
	
	private static final String OBJ_MAP_TOPIC = "map_dir";
//	private static final String OBJ_LST_TOPIC = "list_dir";

	@KafkaListener(topics = OBJ_MAP_TOPIC, groupId = "tutorial")
	public void listenMapMessage(Map<String,Object> msg) {
		log.info("listenMapMessage " + msg);
	}
}
