package com.tutorial.rabbitmq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rabbitmq.entity.TransactionEntity;
import com.tutorial.rabbitmq.impl.TopicImpl;

@RestController
@RequestMapping(value = "/topic")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TopicController {

	@Autowired
	TopicImpl rabbitService;

	@PostMapping(value = "/value/string")
	public ResponseEntity<Object> sendValueTopicStringQueue(@RequestBody Map<String, String> body) {
		rabbitService.sendStringQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [primitive] success.");
	}

	@PostMapping(value = "/value/number")
	public ResponseEntity<Object> sendValueTopicNumberQueue(@RequestBody Map<String, Integer> body) {
		rabbitService.sendNumberQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [primitive] success.");
	}

	@PostMapping(value = "/reference/reference")
	public ResponseEntity<Object> sendValueTopicReferenceQueue(@RequestBody Map<String, Object> body) {
		rabbitService.sendReferenceQueue(body);
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [non-primitive] success.");
	}

	@PostMapping(value = "/reference/object")
	public ResponseEntity<Object> sendValueTopicObjectQueue(@RequestBody TransactionEntity body) {
		rabbitService.sendObjectQueue(body);
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue [non-primitive] success.");
	}
	
	@PostMapping(value = "/value/string/match")
	public ResponseEntity<Object> sendValueTopicMatchQueue(@RequestBody Map<String, String> body) {
		rabbitService.sendMatchQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send topic queue (match) [primitive] success.");
	}
}
