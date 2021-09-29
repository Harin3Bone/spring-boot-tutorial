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
import com.tutorial.rabbitmq.impl.WorkerImpl;

@RestController
@RequestMapping(value = "/worker")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class WorkerController {

	@Autowired
	WorkerImpl rabbitService;

	@PostMapping(value = "/value/string")
	public ResponseEntity<Object> sendValueWorkerStringQueue(@RequestBody Map<String, String> body) {
		rabbitService.publishWorkerValueQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send worker queue [primitive] success.");
	}

	@PostMapping(value = "/value/number")
	public ResponseEntity<Object> sendValueWorkerNumberQueue(@RequestBody Map<String, Integer> body) {
		rabbitService.publishWorkerValueQueue(body.get("key"));
		return ResponseEntity.status(HttpStatus.OK).body("Send worker queue [primitive] success.");
	}

	@PostMapping(value = "/value/reference")
	public ResponseEntity<Object> sendValueWorkerReferenceQueue(@RequestBody Map<String, Object> body) {
		rabbitService.publishWorkerReferenceQueue(body);
		return ResponseEntity.status(HttpStatus.OK).body("Send worker queue [non-primitive] success.");
	}

	@PostMapping(value = "/value/object")
	public ResponseEntity<Object> sendValueWorkerObjectQueue(@RequestBody TransactionEntity body) {
		rabbitService.publishWorkerObjectQueue(body);
		return ResponseEntity.status(HttpStatus.OK).body("Send worker queue [non-primitive] success.");
	}
}
