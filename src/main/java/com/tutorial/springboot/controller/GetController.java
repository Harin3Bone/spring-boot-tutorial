package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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
		System.out.println("GetMapping pathParam = " + pathParam);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [PathParam] success, @PathVariable = " + pathParam);
	}

	@GetMapping(value = "query")
	public ResponseEntity<Object> getMappingWithQuery(@RequestParam(name = "query") String queryParam) {
		System.out.println("GetMapping queryParam = " + queryParam);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [QueryParam] success, @RequestParam = " + queryParam);
	}

	@GetMapping(value = "header")
	public ResponseEntity<Object> getMappingWithHeader(@RequestHeader(name = "header") String requestHeader) {
		System.out.println("GetMapping requestHeader =" + requestHeader);
		return ResponseEntity.status(HttpStatus.OK)
				.body("GetMapping [RequestHeader] success, @RequestHeader = " + requestHeader);
	}
}
