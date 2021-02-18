package com.tutorial.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String language;

	private String framework;

	protected Student() {
	}

	public Student(String name, String language, String framework) {
		this.name = name;
		this.language = language;
		this.framework = framework;
	}
}