package com.tutorial.springboot.model;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class LombokResModel {

	private String message;
	
	private Object data;
}
