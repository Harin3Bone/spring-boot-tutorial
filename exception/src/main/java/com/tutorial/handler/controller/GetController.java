package com.tutorial.handler.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.handler.service.MainService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class GetController {

	@Autowired
	MainService mainService;

	private final String endpoint = "/tutorial";

	@GetMapping(value = "")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> reqGetApi() {
		var map = new LinkedHashMap<String, Object>();
		map.put("endpoint", endpoint);
		map.put("description", "Request GET [Simple]");
		map.put("result", "");
		return map;
	}

	@GetMapping(value = "/path/{param}")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> reqGetApiPath(@PathVariable(name = "param") String param) {
		var map = new LinkedHashMap<String, Object>();
		map.put("endpoint", endpoint + "/path/" + param);
		map.put("description", "Request GET [Path]");
		map.put("result", param);
		return map;
	}

	@GetMapping(value = "/query")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> reqGetApiQuery(@RequestParam(name = "param") String param) {
		var map = new LinkedHashMap<String, Object>();
		map.put("endpoint", endpoint + "/query" + param);
		map.put("description", "Request GET [Query]");
		map.put("result", param);
		return map;
	}
}
