package com.tutorial.rabbitmq.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String txNo;
	private String txType;
	private String txDate;
}
