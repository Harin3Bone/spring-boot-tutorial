package com.tutorial.websocket.controller;

import java.sql.Timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.websocket.message.MessageCaller;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Log4j2
public class WebSocketController {

	@MessageMapping(value = "/websocket")
	@SendTo(value = "/topic/app")
	public ResponseEntity<Object> websocketSample(MessageCaller caller) throws Exception {
		log.info("websocketSample " + new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1000);
		return ResponseEntity.ok("Hello World !!!");
	}
}
