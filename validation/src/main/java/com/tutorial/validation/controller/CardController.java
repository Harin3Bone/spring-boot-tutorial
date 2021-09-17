package com.tutorial.validation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.validation.entity.CardEntity;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/card")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Validated
@Log4j2
public class CardController {

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Object> getCardById(@PathVariable(name = "id", required = true) long id) {
		log.info("getCardById Begin.");

		log.info("getCardById Finish.");
		return new HashMap<>();
	}

	@GetMapping(value = "")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String, Object> createCard(@Valid @RequestBody CardEntity body) {
		log.info("createCard Begin.");

		log.info("createCard Finish.");
		return new HashMap<>();
	}

}
