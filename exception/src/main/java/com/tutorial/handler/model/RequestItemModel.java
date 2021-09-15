package com.tutorial.handler.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestItemModel {

	@NotNull
	private String iArg1;
	
	@NotBlank
	private String iArg2;
	
	@NotEmpty
	private String iArg3;
	
}
