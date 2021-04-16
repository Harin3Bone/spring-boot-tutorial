package com.tutorial.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class RequestController {

	@RequestMapping(value = "/all")
	public ResponseEntity<Object> allRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - ALL");
	}
	
	@RequestMapping(value = "/fixed", method = RequestMethod.GET)
	public ResponseEntity<Object> getRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - GET");
	}
	
	@RequestMapping(value = "/fixed", method = RequestMethod.POST)
	public ResponseEntity<Object> postRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - POST");
	}
	
	@RequestMapping(value = "/fixed", method = RequestMethod.PUT)
	public ResponseEntity<Object> putRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - PUT");
	}
	
	@RequestMapping(value = "/fixed", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - DELETE");
	}
	
	@RequestMapping(value = "/fixed", method = RequestMethod.PATCH)
	public ResponseEntity<Object> patchRequestMapping(){
		return ResponseEntity.status(HttpStatus.OK).body("@RequestMapping - PATCH");
	}
	
}
