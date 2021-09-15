package com.tutorial.handler.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {

	private String timestamp;
	private String message;
	private Object result;

	public ResponseModel(String message, Object result) {
		super();
		this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
		this.message = message;
		this.result = result;
	}
}
