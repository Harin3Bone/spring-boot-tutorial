package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category RequestMapping Example
 */

@RestController
public class RequestController {

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public ResponseEntity<Object> getRequest() {
		System.out.println("RequestMapping GET");
		return ResponseEntity.status(HttpStatus.OK).body("RequestMapping GET");
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public ResponseEntity<Object> postRequest() {
		System.out.println("RequestMapping POST Method");
		return ResponseEntity.status(HttpStatus.CREATED).body("Request POST Method");
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.PUT)
	public ResponseEntity<Object> putRequest() {
		System.out.println("RequestMapping PUT Method");
		return ResponseEntity.status(HttpStatus.OK).body("Request PUT Method");
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRequest() {
		System.out.println("RequestMapping DELETE Method");
		return ResponseEntity.status(HttpStatus.OK).body("Request DELETE Method");
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.PATCH)
	public ResponseEntity<Object> patchRequest() {
		System.out.println("RequestMapping PATCH Method");
		return ResponseEntity.status(HttpStatus.OK).body("Request PATCH Method");
	}
}
