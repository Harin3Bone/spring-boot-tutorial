package com.tutorial.handler.helper;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.tutorial.handler.model.ResponseModel;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadHandler {

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseModel handleMissingParameter(MissingServletRequestParameterException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Missing parameter name '" + e.getParameterName() + "' <" + e.getParameterType() + ">");

		return new ResponseModel("MissingServletRequestParameterException", res);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseModel handleMismatchMethod(MethodArgumentTypeMismatchException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Parameter name '" + e.getParameter().getParameterName() + "' require " + e.getRequiredType());

		return new ResponseModel("MethodArgumentTypeMismatchException", res);
	}

}
