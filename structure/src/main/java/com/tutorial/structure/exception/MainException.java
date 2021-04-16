package com.tutorial.structure.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tutorial.structure.util.MainUtil;

@RestControllerAdvice
public class MainException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Map<String,Object>> notFoundErr(){
		Map<String,Object> res = new MainUtil().errRes(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> internalErr(){
		Map<String,Object> res = new MainUtil().errRes(HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
	
}
