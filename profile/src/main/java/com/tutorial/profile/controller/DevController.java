package com.tutorial.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dev")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Profile(value = { "dev" })
public class DevController {

	@Autowired
	Environment env;

	@GetMapping(value = "")
	public ResponseEntity<Object> getLocalProfile() {
		return ResponseEntity.ok(env.getProperty("message"));
	}
}
