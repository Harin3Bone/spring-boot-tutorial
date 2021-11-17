package com.tutorial.jdbc.service;

import java.util.List;
import java.util.Map;

import com.tutorial.jdbc.entity.ServantEntity;

public interface ServantService {
	
	public List<Map<String, Object>> getAllServant();

	public Map<String, Object> getServantById(String id);

	public void createdServant(ServantEntity model);

	public void updateServantById(ServantEntity model);

	public void deleteAllServant();

	public void deleteServantById(String id);
}
