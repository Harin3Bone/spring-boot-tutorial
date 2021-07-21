package com.tutorial.api.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.api.entity.ResponseModel;

@RestController
@RequestMapping(value = "/res")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ResponseController {

	@GetMapping(value = "/type1")
	public ResponseEntity<Object> returnJsonWithMap() {
		var res = new HashMap<String, Object>();
		res.put("res", "type1");
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@GetMapping(value = "/type2")
	public ResponseEntity<Object> returnJsonWithObject() {
		var res = new ResponseModel("type2");
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@GetMapping(value = "/type3")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseModel returnJsonWithoutEntity() {
		return new ResponseModel("type3");
	}
}
