package com.tutorial.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@PostMapping(value = "/simple")
	public ResponseEntity<Object> postMapping() {
		System.out.println("PostMapping success");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping success");
	}

	@PostMapping(value = "/body/obj")
	public ResponseEntity<Object> postMappingWithObj(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with JSONObject");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONObject, Body = " + body);
	}
	
	@PostMapping(value = "/body/arr")
	public ResponseEntity<Object> postMappingWithArr(@RequestBody List<Object> body){
		System.out.println("PostMapping with JSONArray");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONArray, Body = " + body);
	}
}
