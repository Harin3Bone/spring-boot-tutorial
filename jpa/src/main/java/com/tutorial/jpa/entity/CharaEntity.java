package com.tutorial.jpa.entity;

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
@Table(name = "Character")
public class CharaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private long id;
	
	@Column(name = "name",unique = true)
	@NotNull
	private String name;
	
	@Column(name = "class")
	@NotNull
	private String clss;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "level")
	private int lv;
}
