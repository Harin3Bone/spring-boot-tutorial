package com.tutorial.jdbc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServantService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAllServant(){
		try {
			String sql = "SELECT * FROM Servant";
			
			List<Map<String, Object>> lst = jdbcTemplate.queryForList(sql);
			
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
