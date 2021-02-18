package com.tutorial.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.entity.StudentEntity;
import com.tutorial.springboot.model.TemplateResModel;
import com.tutorial.springboot.service.StudentService;

/**
 * @author Harin Thananam
 * @since 18 FEB 2021
 * @category H2 Example
 */

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students")
	public ResponseEntity<Object> getAllStudent() {
		List<StudentEntity> data = studentService.getAllStudent();
		String message = "Success with " + data.size() + " row(s)";
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") long id) {
		StudentEntity data = studentService.getStudentById(id);
		String message = "Success found id " + data.getId();
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@PostMapping(value = "/student")
	public ResponseEntity<Object> saveStudent(@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.saveStudent(body);
		String message = "Create student success";
		HttpStatus status = HttpStatus.CREATED;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@PostMapping(value = "/students")
	public ResponseEntity<Object> saveStudentList(@RequestBody List<Map<String, Object>> body) {
		List<StudentEntity> data = studentService.saveStudentList(body);
		String message = "Create student success " + data.size() + " row(s)";
		HttpStatus status = HttpStatus.CREATED;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}

	@PutMapping(value = "/student/{id}")
	public ResponseEntity<Object> updateStudentById(@PathVariable("id") long id,
			@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.updateStudent(id, body);
		String message = "Update id " + data.getId() + " success";
		HttpStatus status = HttpStatus.OK;

		TemplateResModel res = new TemplateResModel(status, message, data);
		return ResponseEntity.status(status).body(res);
	}
	
	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		String message = "Delete id " + id + " success";
		HttpStatus status = HttpStatus.OK;
		
		TemplateResModel res = new TemplateResModel(status, message, "");
		return ResponseEntity.status(status).body(res);
	}
}
