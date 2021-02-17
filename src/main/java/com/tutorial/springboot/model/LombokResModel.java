package com.tutorial.springboot.model;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ResponseBody
@Getter
@Setter
@AllArgsConstructor
public class LombokResModel {

	private String message;
	
	private Object data;
}
