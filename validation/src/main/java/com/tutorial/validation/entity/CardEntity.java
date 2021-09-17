package com.tutorial.validation.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {

	@NotNull
	private long id;

	@NotBlank
	private String name;

	@PositiveOrZero
	private short level;

	@Positive
	private int atk;

	@Positive
	private int def;

	@NotEmpty
	private String skill;

}
