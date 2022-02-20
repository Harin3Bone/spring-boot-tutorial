package com.tutorial.kafka.model;

import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Profile(value = { "obj" })
public class ObjectModel {

	private String msg;
	private int num;
}
