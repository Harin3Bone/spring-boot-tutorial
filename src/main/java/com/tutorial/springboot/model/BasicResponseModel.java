package com.tutorial.springboot.model;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@ResponseBody
@Getter
@Setter
public class BasicResponseModel {

	private String message;
	
	private Object data;
	
	public BasicResponseModel(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	
}
