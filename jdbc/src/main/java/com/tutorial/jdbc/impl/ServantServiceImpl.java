package com.tutorial.jdbc.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tutorial.jdbc.entity.ServantEntity;
import com.tutorial.jdbc.service.ServantService;

@Service
@Profile(value = { "h2", "mysql", "postgres" })
public class ServantServiceImpl implements ServantService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getAllServant(){
		try {
			String sql = "SELECT * FROM Servant";				
			
			return jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public Map<String, Object> getServantById(String id){
		try {
			String sql = "SELECT * FROM Servant WHERE id = " + id;
			
			return jdbcTemplate.queryForMap(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void createdServant(ServantEntity model) {
		try {
			String sql = "INSERT INTO Servant (ID,NAME,CLASS,RARITY,MYTH) VALUES ";
			sql += "(";
			sql += model.getId() + ",";
			sql += "'" + model.getName() + "',";
			sql += "'" + model.getClasses() + "',";
			sql += "'" + model.getRarity() + "',";
			sql += "'" + model.getMyth() + "'";
			sql += ");";
			
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void updateServantById(ServantEntity model) {
		try {
			var sql = new StringBuilder();
			sql.append("UPDATE Servant SET ");
			sql.append(" NAME = '" + model.getName() + "',");
			sql.append(" CLASS = '" + model.getClasses() + "',");
			sql.append(" RARITY = '" + model.getRarity() + "',");
			sql.append(" MYTH = '" + model.getMyth() + "'");
			sql.append(" WHERE ID = " + model.getId());
			
			jdbcTemplate.execute(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void deleteAllServant() {
		try {
			var sql ="DELETE FROM Servant";
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void deleteServantById(String id) {
		try {
			var sql ="DELETE FROM Servant WHERE ID = " + id;
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
