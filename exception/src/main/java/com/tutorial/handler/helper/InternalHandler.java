package com.tutorial.handler.helper;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutorial.handler.model.ResponseModel;

@RestControllerAdvice
public class InternalHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseModel handleMediaTypeNotSupport(Exception e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Unexpect error exception.");

		return new ResponseModel(e.getClass().getSimpleName(), res);
	}
}
