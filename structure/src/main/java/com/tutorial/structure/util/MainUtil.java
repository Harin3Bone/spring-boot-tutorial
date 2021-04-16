package com.tutorial.structure.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class MainUtil {

	@SuppressWarnings("serial")
	public Map<String,Object> errRes(HttpStatus status){
		return new LinkedHashMap<String,Object>(){{
			put("message", status);
			put("status", status.value());
		}}; 
	}
}
