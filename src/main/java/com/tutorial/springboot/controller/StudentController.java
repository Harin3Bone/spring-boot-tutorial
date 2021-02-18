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

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students")
	public ResponseEntity<Object> getAllStudent() {
		List<StudentEntity> data = studentService.getAllStudent();
		String message = "Success with " + data.size() + " row(s)";

		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, data);
		return ResponseEntity.ok().body(res);
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") long id) {
		StudentEntity data = studentService.getStudentById(id);
		String message = "Success found id " + data.getId();

		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, data);
		return ResponseEntity.ok().body(res);
	}

	@PostMapping(value = "/student")
	public ResponseEntity<Object> saveStudent(@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.saveStudent(body);
		String message = "Create student success";

		TemplateResModel res = new TemplateResModel(HttpStatus.CREATED, message, data);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@PostMapping(value = "/students")
	public ResponseEntity<Object> saveStudentList(@RequestBody List<Map<String, Object>> body) {
		List<StudentEntity> data = studentService.saveStudentList(body);
		String message = "Create student success " + data.size() + " row(s)";

		TemplateResModel res = new TemplateResModel(HttpStatus.CREATED, message, data);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@PutMapping(value = "/student/{id}")
	public ResponseEntity<Object> updateStudentById(@PathVariable("id") long id,
			@RequestBody Map<String, Object> body) {
		StudentEntity data = studentService.updateStudent(id, body);
		String message = "Update id " + data.getId() + " success";

		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, data);
		return ResponseEntity.ok().body(res);
	}
	
	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		String message = "Delete id " + id + " success";
		
		TemplateResModel res = new TemplateResModel(HttpStatus.OK, message, "");
		return ResponseEntity.ok().body(res);
	}
}
