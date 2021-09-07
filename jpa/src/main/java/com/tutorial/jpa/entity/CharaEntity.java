package com.tutorial.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.tutorial.jpa.dto.CharaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public CharaEntity(CharaDTO dto) {
		super();
		this.name = dto.getName();
		this.clss = dto.getClss();
		this.label = dto.getLabel();
		this.lv = dto.getLv();
	}
	
	public CharaEntity(long id, CharaDTO dto) {
		super();
		this.id = id;
		this.name = dto.getName();
		this.clss = dto.getClss();
		this.label = dto.getLabel();
		this.lv = dto.getLv();
	}
}
