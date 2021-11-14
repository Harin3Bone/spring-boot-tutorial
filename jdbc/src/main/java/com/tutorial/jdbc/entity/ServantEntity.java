package com.tutorial.jdbc.entity;

import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Profile(value = { "h2", "mysql", "postgres" })
public class ServantEntity {

	private long id;
	private String name;
	private String classes;
	private String rarity;
	private String myth;
}
