package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@PostMapping(value = "/simple")
	public ResponseEntity<Object> postMapping(){
		System.out.println("PostMapping success");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping success");
	}	
	
}
