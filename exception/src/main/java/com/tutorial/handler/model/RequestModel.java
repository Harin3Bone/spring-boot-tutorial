package com.tutorial.handler.model;

import javax.validation.Valid;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {

	@Positive
	private long arg1;
	
	@PositiveOrZero
	private int arg2;
	
	private int arg3;
	
	@Negative
	private int arg4;

	@NegativeOrZero
	private int arg5;
	
	@Valid
	private RequestItemModel item;

}
