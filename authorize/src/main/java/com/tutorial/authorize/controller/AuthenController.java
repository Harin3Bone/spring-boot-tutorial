package com.tutorial.authorize.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AuthenController {

	@PostMapping
	public ResponseEntity<Object> signIn(@RequestBody Map<String, Object> body) {
		
		
		return ResponseEntity.of(Optional.of(new HashMap<>()));
	}
}
