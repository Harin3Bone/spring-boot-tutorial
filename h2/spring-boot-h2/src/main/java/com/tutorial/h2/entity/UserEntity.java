package com.tutorial.h2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 250)
	@NotNull
	private String name;

	@Column(name = "language", length = 100, nullable = true)
	private String language;

	@Column(name = "framework", length = 100, nullable = true)
	private String framework;

	protected UserEntity() {
	}

	public UserEntity(String name, String language, String framework) {
		this.name = name;
		this.language = language;
		this.framework = framework;
	}
}
