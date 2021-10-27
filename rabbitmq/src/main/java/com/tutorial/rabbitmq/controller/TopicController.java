package com.tutorial.rabbitmq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rabbitmq.impl.TopicImpl;

@RestController
@RequestMapping(value = "/topic")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TopicController {

	@Autowired
	TopicImpl rabbitService;

	@PostMapping(value = "/value/small")
	public ResponseEntity<Object> sendValueTopicSmallQueue(@RequestBody Map<String, String> body) {
		rabbitService.sendStringSmallQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [small] success.");
	}

	@PostMapping(value = "/value/large")
	public ResponseEntity<Object> sendValueTopicLargeQueue(@RequestBody Map<String, String> body) {
		rabbitService.sendStringLargeQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [large] success.");
	}

	@PostMapping(value = "/value/{value}")
	public ResponseEntity<Object> sendValueTopicLargeQueue(@RequestBody Map<String, String> body,
			@PathVariable(name = "value") String value) {
		rabbitService.sendStringLargeQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [large] success.");
	}
}
