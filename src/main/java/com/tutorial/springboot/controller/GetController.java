package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping(value = "/simple")
	public ResponseEntity<Object> getMapping() {
		System.out.println("GetMapping");
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping success");
	}
}
