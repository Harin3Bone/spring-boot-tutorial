package com.tutorial.structure.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> mainApi(Exception e){
		return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
	}

}
