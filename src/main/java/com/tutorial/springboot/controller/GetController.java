package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping(value = "/simple")
	public ResponseEntity<Object> getMapping() {
		System.out.println("GetMapping");
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping success");
	}

	@GetMapping(value = "/path/{path}")
	public ResponseEntity<Object> getMappingWithPath(@PathVariable(name = "path") String pathParam) {
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping [PathParam] success");
	}

	@GetMapping(value = "query")
	public ResponseEntity<Object> getMappingWithQuery(@RequestParam(name = "query") String queryParam) {
		return ResponseEntity.status(HttpStatus.OK).body("GetMapping [QueryParam] success");
	}
}
