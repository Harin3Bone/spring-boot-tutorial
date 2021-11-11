package com.tutorial.validation.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InternalHandler {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleMissingValidateBody(MethodArgumentNotValidException e) {
		Map<String, Object> res = new HashMap<>();
		for (FieldError err : e.getFieldErrors()) {
			res.put(err.getField(), err.getDefaultMessage());
		}

		return res;
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleMessageNotReadable(HttpMessageNotReadableException e) {
		Map<String, Object> res = new HashMap<>();
		res.put("message", "Body message receive are not readable.");

		return res;
	}

}
