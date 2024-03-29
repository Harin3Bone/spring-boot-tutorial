package com.tutorial.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutorial.api.entity.ResponseModel;

@RestControllerAdvice
public class BasicHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel handleNullPointer(Exception e) {
		return new ResponseModel("NullPointerException");
	}
	
}
