package com.tutorial.handler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.handler.exception.CustomizeException;
import com.tutorial.handler.model.ResponseModel;

@RestController
@RequestMapping(value = "/error")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@ResponseStatus(code = HttpStatus.OK)
public class ErrorController {

	@GetMapping(value = "/customize")
	public ResponseModel reqApiCustomizeError() {
		throw new CustomizeException("Request GET [CustomizeException]");
	}

	@GetMapping(value = "/catch")
	public ResponseModel reqApiCatchError() {
		String msg = "error";
		try {
			int num = Integer.parseInt(msg);
			return new ResponseModel("Request GET [NumberFormatException]", num);
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	@GetMapping(value = "/uncatch")
	public ResponseModel reqApiUncatchError() {
		int num = 1 / 0;

		return new ResponseModel("Request GET [DivideByZeroException]", num);
	}

}
