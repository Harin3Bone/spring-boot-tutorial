package com.tutorial.handler.helper;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tutorial.handler.model.ResponseModel;

@RestControllerAdvice
public class BadHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseModel handleNoHandlerFound(NoHandlerFoundException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "API not found");
		return new ResponseModel("NoHandlerFoundException", res);
    }

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseModel handleMissingParameter(MissingServletRequestParameterException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Missing parameter name '" + e.getParameterName() + "' <" + e.getParameterType() + ">");

		return new ResponseModel("MissingServletRequestParameterException", res);
	}	

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseModel handleMismatchMethod(MethodArgumentTypeMismatchException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Parameter name '" + e.getParameter().getParameterName() + "' require " + e.getRequiredType());

		return new ResponseModel("MethodArgumentTypeMismatchException", res);
	}
	
	@ExceptionHandler(value = MissingServletRequestPartException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseModel handleMissingMultipart(MissingServletRequestPartException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Missing multipart parameter name '" + e.getRequestPartName() + "'");

		return new ResponseModel("MissingServletRequestParameterException", res);
	}
	
	@ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public ResponseModel handleMediaTypeNotSupport(HttpMediaTypeNotSupportedException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Support MediaType only '" + e.getSupportedMediaTypes() + "'");

		return new ResponseModel("MethodArgumentTypeMismatchException", res);
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	public ResponseModel handleMediaTypeNotSupport(HttpRequestMethodNotSupportedException e) {
		var res = new HashMap<Integer, String>();
		res.put(0, "Not support for method " + e.getMethod());

		return new ResponseModel("MethodArgumentTypeMismatchException", res);
	}
	
}
