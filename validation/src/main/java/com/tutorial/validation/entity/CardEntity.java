package com.tutorial.validation.entity;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	private String serial;

	@NotBlank
	private String name;

	@NotEmpty
	private String alias;

	@Positive
	private short level;

	@PositiveOrZero
	private int atk;

	@PositiveOrZero
	private int def;

	private String skill;

	@Min(value = 0)
	@Max(value = 12)
	private short scale;

	@Min(value = 0)
	@Max(value = 8)
	private short marker;

	@AssertTrue
	private boolean available;
	
	@AssertFalse
	private boolean limited;
	
	@NotBlank
	@Pattern(regexp = "(^EARTH$)|(^WATER$)|(^WIND$)|(^FIRE$)|(^LIGHT$)|(^DARK$)")
	private String attribute;
	
	@Email
	private String illustrator;
}
