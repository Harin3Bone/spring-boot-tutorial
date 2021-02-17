package com.tutorial.springboot.model;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Harin Thananam
 * @since 17 FEB 2021
 * @category Part of ModelController
 */

@ResponseBody
@Getter
@Setter
public class TemplateResModel {

	private String timestamp;
	
	private int status;
	
	private String message;
	
	private Object data;
	
	public TemplateResModel(HttpStatus status,String message,Object data) {
		super();
		this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
		this.status = status.value();
		this.message = message;
		this.data = data;
	}
}
