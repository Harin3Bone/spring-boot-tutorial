package com.tutorial.h2.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

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

import com.tutorial.h2.entity.UserEntity;
import com.tutorial.h2.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Resource
	private UserRepository userRepository;

	@GetMapping(value = "")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> response = userRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable(name = "id") long id) {
		Optional<UserEntity> response = userRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping(value = "")
	public ResponseEntity<Object> createUser(@RequestBody UserEntity body) {
		userRepository.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(name = "id") long id, @RequestBody UserEntity body) {
		UserEntity user = userRepository.findById(id).get();
		
		user.setName(body.getName());
		user.setFramework(body.getFramework());
		user.setLanguage(body.getLanguage());
		
		userRepository.save(user);
		
		return ResponseEntity.status(HttpStatus.OK).body("Update success");
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable(name = "id") long id) {
		userRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete success");
	}
}
