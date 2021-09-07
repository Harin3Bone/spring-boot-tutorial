package com.tutorial.openapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Member")
@Data
@Entity
@Table(name = "Member")
public class MemberEntity {

	@Hidden
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private long id;

	@Schema(name = "name", description = "Member name", example = "Harin", required = true)
	@Column(name = "name",unique = true)
	@NotNull
	private String name;
	
	@Schema(name = "job", description = "Job description", example = "Backend Developer", required = true)
	@Column(name = "job",unique = true)
	@NotNull
	private String job;
	
	@Schema(name = "lang", description = "Programming language", example = "Java", required = true)
	@Column(name = "lang",unique = true)
	@NotNull
	private String lang;
	
}
