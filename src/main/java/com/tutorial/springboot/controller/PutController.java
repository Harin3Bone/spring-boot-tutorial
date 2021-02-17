package com.tutorial.springboot.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category PUT Example
 * */

@RestController
public class PutController {

	/**
	 * @apiNote http://localhost:3000/simple
	 * @response text/plain
	 */
	@PutMapping(value = "/simple")
	public ResponseEntity<Object> putMapping() {
		System.out.println("PutMapping success");
		return ResponseEntity.status(HttpStatus.OK).body("PutMapping success");
	}

	/**
	 * @apiNote http://localhost:3000/simple
	 * @body application/json {}
	 * @response application/json
	 */
	@PutMapping(value = "/body", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putMappingWithBody(@RequestBody Map<String, Object> body) {
		System.out.println("PutMapping with Body");
		return ResponseEntity.status(HttpStatus.OK).body("PutMapping with Body");
	}
}
