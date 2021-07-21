package com.tutorial.api.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.api.entity.ResponseModel;

@RestController
@RequestMapping(value = "/err")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ErrorController {

	@GetMapping(value = "nocatch")
	public ResponseEntity<Object> exampleError() {
		var num = Integer.parseInt("Exception");
		return ResponseEntity.status(HttpStatus.OK).body(num);
	}

	@GetMapping(value = "catch")
	public ResponseModel exampleHandleError() {
		try {
			var mp = new HashMap<String, Object>();
			var res = mp.get("value").toString();
			return new ResponseModel(res);
		} catch (NullPointerException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
