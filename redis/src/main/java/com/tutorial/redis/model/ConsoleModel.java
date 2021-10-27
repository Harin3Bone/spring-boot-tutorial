package com.tutorial.redis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "console")
public class ConsoleModel {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String company;	
}
