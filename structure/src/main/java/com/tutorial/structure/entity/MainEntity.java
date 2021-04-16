package com.tutorial.structure.entity;

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
@Table(name = "main")
public class MainEntity {

	@Id
	@Column(name = "key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull 
	private long key;
	
	@Column(name = "value", unique = true)
	@NotNull
	private String value;
}
