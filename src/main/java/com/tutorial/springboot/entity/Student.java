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
	
	private String skill;

	protected Student() {
	}

	public Student(String quirk, String name) {
		this.name = name;
		this.skill = quirk;
	}
}