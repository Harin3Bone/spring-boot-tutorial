package com.tutorial.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.model.BasicResModel;
import com.tutorial.springboot.model.LombokResModel;

@RestController
@RequestMapping(value = "/model")
public class ModelController {

	/**
	 * @apiNote http://localhost:3000/model/basic/...
	 * @response application/json
	 */
	@GetMapping(value = "/basic/{variable}")
	public ResponseEntity<Object> reqBasicResponse(@PathVariable("variable") String variable) {
		String message = "ServiceController.java, reqBasicResponse()";
		System.out.println(message);
		BasicResModel res = new BasicResModel(message, variable);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	/**
	 * @apiNote http://localhost:3000/model/lombok/...
	 * @response application/json
	 */
	@GetMapping(value = "/lombok/{variable}")
	public ResponseEntity<Object> reqLombokResponse(@PathVariable("variable") String variable) {
		String message = "ServiceController.java, reqLombokResponse()";
		System.out.println(message);
		LombokResModel res = new LombokResModel(message, variable);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
