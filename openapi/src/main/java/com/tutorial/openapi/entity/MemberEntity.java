package com.tutorial.openapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "Member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private long id;
	
	@Column(name = "name",unique = true)
	@NotNull
	private String name;
	
	@Column(name = "job",unique = true)
	@NotNull
	private String job;
	
	@Column(name = "lang",unique = true)
	@NotNull
	private String lang;
	
}
