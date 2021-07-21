package com.tutorial.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/err")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class ErrorController {

	@GetMapping(value = "")
	public ResponseEntity<Object> exampleError(){
		var num = Integer.parseInt("XXX");
		return ResponseEntity.status(HttpStatus.OK).body(num);
	}
}
