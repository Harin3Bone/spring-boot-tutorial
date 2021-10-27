package com.tutorial.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.redis.impl.ConsoleServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ConsoleController {

	@Autowired
	ConsoleServiceImpl consoleService;
	
	@GetMapping(value = "")
	public ResponseEntity<Object> getAllConsole(){
		var consoles = consoleService.getAllConsole();
		return ResponseEntity.status(HttpStatus.OK).body(consoles);
	}
}
