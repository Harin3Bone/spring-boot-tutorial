package com.tutorial.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServantEntity {

	private long id;
	private String name;
	private String classes;
	private String rarity;
	private String myth;
}
