package com.tutorial.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category POST Example
 * */

@RestController
public class PostController {

	/**
	 * @apiNote http://localhost:3000/simple
	 * @response text/plain
	 * */
	@PostMapping(value = "/simple")
	public ResponseEntity<Object> postMapping() {
		System.out.println("PostMapping success");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping success");
	}

	/**
	 * @apiNote http://localhost:3000/body/obj
	 * @body application/json {}
	 * @response text/plain
	 * */
	@PostMapping(value = "/body/obj")
	public ResponseEntity<Object> postMappingWithObj(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with JSONObject");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONObject, Body = " + body);
	}

	/**
	 * @apiNote http://localhost:3000/body/arr
	 * @body application/json []
	 * @response text/plain
	 * */
	@PostMapping(value = "/body/arr")
	public ResponseEntity<Object> postMappingWithArr(@RequestBody List<Object> body) {
		System.out.println("PostMapping with JSONArray");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with JSONArray, Body = " + body);
	}

	/**
	 * @apiNote http://localhost:3000/consumes
	 * @body application/json {}
	 * @response text/plain
	 * */
	@PostMapping(value = "/consumes", consumes = "application/json")
	public ResponseEntity<Object> postMappingByConsume(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with Consumes application/json");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with Consumes application/json");
	}

	/**
	 * @apiNote http://localhost:3000/produces
	 * @body application/json {}
	 * @response text/plain
	 * */
	@PostMapping(value = "/produces", produces = "application/json")
	public ResponseEntity<Object> postMappingByProduce(@RequestBody Map<String, Object> body) {
		System.out.println("PostMapping with Produces application/json");
		return ResponseEntity.status(HttpStatus.CREATED).body("PostMapping with Produces application/json");
	}
}
