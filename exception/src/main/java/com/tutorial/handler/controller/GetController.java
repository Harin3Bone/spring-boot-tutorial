package com.tutorial.handler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.handler.model.ResponseModel;
import com.tutorial.handler.service.MainService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@ResponseStatus(code = HttpStatus.OK)
public class GetController {

	@Autowired
	MainService mainService;

	@GetMapping(value = "/simple")
	public ResponseModel reqGetApi() {
		return new ResponseModel("Request GET [Simple]", "");
	}

	@GetMapping(value = "/path/{param}")
	public ResponseModel reqGetApiPath(@PathVariable(name = "param") int param) {
		return new ResponseModel("Request GET [Path]", param);
	}

	@GetMapping(value = "/query")
	public ResponseModel reqGetApiQuery(@RequestParam(name = "param", required = true) String param) {
		return new ResponseModel("Request GET [Query]", param);
	}

}
