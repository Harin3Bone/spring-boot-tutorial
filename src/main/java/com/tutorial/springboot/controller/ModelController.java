package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.model.BasicResponseModel;

@RestController
@RequestMapping(value = "/model")
public class ModelController {

	/**
	 * @apiNote http://localhost:3000/model/template/...
	 * @response application/json
	 */
	@GetMapping(value = "/template/{variable}")
	public ResponseEntity<Object> reqBasicResponse(@PathVariable("variable") String variable) {
		String message = "ServiceController.java, reqBasicResponse()";
		System.out.println(message);
		BasicResponseModel res = new BasicResponseModel(message, variable);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
