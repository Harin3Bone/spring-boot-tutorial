package com.tutorial.jdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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

import com.tutorial.jdbc.entity.ServantEntity;
import com.tutorial.jdbc.impl.MySqlServantImpl;
import com.tutorial.jdbc.impl.PostgresServantImpl;

@RestController
@RequestMapping(value = "/multiple/servant")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Profile(value = { "multi" })
public class MultipleController {

	@Autowired
	private MySqlServantImpl mysqlServantService;
	
	@Autowired
	private PostgresServantImpl postgresServantImpl;

	@GetMapping(value = "/mysql")
	public ResponseEntity<Object> getAllServantMySql() {
		List<Map<String, Object>> lst = mysqlServantService.getAllServant();
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/mysql/{id}")
	public ResponseEntity<Object> getServantByIdMySql(@PathVariable(name = "id") String id) {
		Map<String, Object> res = mysqlServantService.getServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping(value = "/mysql")
	public ResponseEntity<Object> createdServiceMySql(@RequestBody ServantEntity body) {
		mysqlServantService.createdServant(body);
		return ResponseEntity.status(HttpStatus.CREATED).body("create servant success");
	}

	@PutMapping(value = "/mysql")
	public ResponseEntity<Object> updateServantByIdMySql(@RequestBody ServantEntity body) {
		mysqlServantService.updateServantById(body);
		return ResponseEntity.status(HttpStatus.OK).body("update servant success");
	}

	@DeleteMapping(value = "/mysql")
	public ResponseEntity<Object> deleteAllServantMySql() {
		mysqlServantService.deleteAllServant();
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}

	@DeleteMapping(value = "/mysql/{id}")
	public ResponseEntity<Object> deleteServantByIdMySql(@PathVariable(name = "id") String id) {
		mysqlServantService.deleteServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}
	
	@GetMapping(value = "/postgres")
	public ResponseEntity<Object> getAllServantPostgres() {
		List<Map<String, Object>> lst = postgresServantImpl.getAllServant();
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/postgres/{id}")
	public ResponseEntity<Object> getServantByIdPostgres(@PathVariable(name = "id") String id) {
		Map<String, Object> res = postgresServantImpl.getServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PostMapping(value = "/postgres")
	public ResponseEntity<Object> createdServicePostgres(@RequestBody ServantEntity body) {
		postgresServantImpl.createdServant(body);
		return ResponseEntity.status(HttpStatus.CREATED).body("create servant success");
	}

	@PutMapping(value = "/postgres")
	public ResponseEntity<Object> updateServantByIdPostgres(@RequestBody ServantEntity body) {
		postgresServantImpl.updateServantById(body);
		return ResponseEntity.status(HttpStatus.OK).body("update servant success");
	}

	@DeleteMapping(value = "/postgres")
	public ResponseEntity<Object> deleteAllServantPostgres() {
		postgresServantImpl.deleteAllServant();
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}

	@DeleteMapping(value = "/postgres/{id}")
	public ResponseEntity<Object> deleteServantByIdPostgres(@PathVariable(name = "id") String id) {
		postgresServantImpl.deleteServantById(id);
		return ResponseEntity.status(HttpStatus.OK).body("remove servant success");
	}

}
