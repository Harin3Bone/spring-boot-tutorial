package com.tutorial.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tutorial.springboot.entity.StudentEntity;
import com.tutorial.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Resource
	private StudentRepository studentRepository;

	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> data = studentRepository.findAll();
		return data;
	}

	public StudentEntity getStudentById(long id) {
		Optional<StudentEntity> opData = studentRepository.findById(id);
		StudentEntity data = opData.get();
		return data;
	}

	public StudentEntity saveStudent(Map<String, Object> body) {
		String name = body.get("name").toString();
		String language = body.get("language").toString();
		String framework = body.get("framework").toString();		
		StudentEntity data = studentRepository.save(new StudentEntity(name, language, framework));
		return data;
	}
	
	public List<StudentEntity> saveStudentList(List<Map<String, Object>> body) {
		List<StudentEntity> data = new ArrayList<>();
		for (Map<String,Object> obj : body) {
			StudentEntity student = new StudentEntity(obj.get("name").toString(),obj.get("language").toString(),obj.get("framework").toString());
			studentRepository.save(student);
			data.add(student);
		}
		return data;
	}
	
	public StudentEntity updateStudent(long id, Map<String,Object> body) {
		String name = body.get("name").toString();
		String language = body.get("language").toString();
		String framework = body.get("framework").toString();
		
		StudentEntity student = studentRepository.findById(id).get();
		student.setName(name);
		student.setLanguage(language);
		student.setFramework(framework);
		student = studentRepository.save(student);
		
		return student;
	}

}
