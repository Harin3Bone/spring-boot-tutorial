package com.tutorial.validation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.validation.entity.CardEntity;

@RestController
@RequestMapping(value = "/validate")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Validated
public class CardController {

	@PostMapping(value = "/standard")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String, Object> createCard(@Valid @RequestBody CardEntity body) {
		Map<String, Object> res = new HashMap<>();
		res.put("message", "validate pass");
		res.put("result", body);

		return res;
	}

}
