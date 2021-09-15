package com.tutorial.handler.helper;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutorial.handler.exception.CustomizeException;
import com.tutorial.handler.model.ResponseModel;

@RestControllerAdvice
public class InternalHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel handleMediaTypeNotSupport(Exception e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Unexpect error exception.");

		return new ResponseModel("GlobalException", res);
	}

	@ExceptionHandler(value = CustomizeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel handleMediaTypeNotSupport(CustomizeException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, e.getMessage());

		return new ResponseModel("CustomizeException", res);
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel handleNumberFormat(NumberFormatException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Cannot parse String to Integer");

		return new ResponseModel("NumberFormatException", res);
	}	
}
