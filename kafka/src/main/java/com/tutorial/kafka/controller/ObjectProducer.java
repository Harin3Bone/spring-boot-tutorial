package com.tutorial.kafka.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.kafka.service.KafkaService;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping(value = "/object")
@Profile(value = { "obj" })
@Log4j2
public class ObjectProducer {

	private static final String OBJ_MAP_TOPIC = "map_dir";
//	private static final String OBJ_LST_TOPIC = "list_dir";
	
	@Autowired
	KafkaService kafkaService;
	
	@PostMapping(value = "/map")
	public ResponseEntity<Object> sendMapMessage(@RequestBody Map<String, Object> body) {
		log.info("sendMapMessage Begin.");
		kafkaService.produceStringMessage(OBJ_MAP_TOPIC, body.get("msg").toString());

		body.put("status", "success");
		log.info("sendMapMessage Finished.");
		return ResponseEntity.ok(body);
	}
	
}
