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
@RequestMapping(value = "/send")
@Log4j2
public class QueueProducer {

	@Autowired
	KafkaService kafkaService;

	@PostMapping(value = "/message")
	public ResponseEntity<Map<String, Object>> sendStringMessage(@RequestBody Map<String, Object> body) {
		log.info("sendStringMessage Begin.");
		kafkaService.produceStringMessage(body.get("msg").toString());
		
		body.put("status", "success");
		log.info("sendStringMessage Finished.");
		return ResponseEntity.ok(body);
	}
}
