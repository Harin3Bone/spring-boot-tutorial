package com.tutorial.kafka.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/message")
@Log4j2
public class StringProducer {

	private static final String MSG_DIR_TOPIC = "message_dir";
	private static final String MSG_CON_TOPIC = "message_con";

	@Autowired
	KafkaService kafkaService;

	@PostMapping(value = "/direct")
	public ResponseEntity<Map<String, Object>> sendStringMessage(@RequestBody Map<String, Object> body) {
		log.info("sendStringMessage Begin.");
		kafkaService.produceStringMessage(MSG_DIR_TOPIC, body.get("msg").toString());

		body.put("status", "success");
		log.info("sendStringMessage Finished.");
		return ResponseEntity.ok(body);
	}

	@PostMapping(value = "/cosumer")
	public ResponseEntity<Map<String, Object>> sendStringMessageConsumer(@RequestBody Map<String, Object> body) {
		log.info("sendStringMessageConsumer Begin.");
		kafkaService.produceStringMessage(MSG_CON_TOPIC, body.get("msg").toString());

		body.put("status", "success");
		log.info("sendStringMessageConsumer Finished.");
		return ResponseEntity.ok(body);
	}
}
