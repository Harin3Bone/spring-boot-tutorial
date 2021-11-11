package com.tutorial.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.redis.impl.ConsoleServiceImpl;
import com.tutorial.redis.model.ConsoleModel;

@RestController
@RequestMapping(value = "/console")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ConsoleController {

	@Autowired
	ConsoleServiceImpl consoleService;

	@GetMapping(value = "")
	public ResponseEntity<Object> getAllConsole() {
		var res = consoleService.getAllConsole();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getConsoleById(@PathVariable(name = "id") long id) {
		var res = consoleService.getConsoleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping(value = "")
	public ResponseEntity<Object> createConsole(@RequestBody ConsoleModel body) {
		consoleService.createConsole(body);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PutMapping(value = "")
	public ResponseEntity<Object> updateConsole(@RequestBody ConsoleModel body) {
		consoleService.updateConsole(body.getId(), body);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteConsoleById(@PathVariable(name = "id") long id) {
		consoleService.deleteConsole(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}
