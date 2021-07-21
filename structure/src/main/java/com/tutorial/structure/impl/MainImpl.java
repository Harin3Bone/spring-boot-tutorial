package com.tutorial.structure.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tutorial.structure.entity.MainEntity;
import com.tutorial.structure.repository.MainRepo;
import com.tutorial.structure.service.MainService;

@Service
public class MainImpl implements MainService {
	
	@Resource
	private MainRepo mainRepo;
	
	public Map<String,Object> resMainApi(){
		try {
			List<MainEntity> msg = mainRepo.findAll();
			
			LinkedHashMap<String,Object> res = new LinkedHashMap<String,Object>();
			res.put("message", msg);
			res.put("status", HttpStatus.OK.value());
			
			return res;
		} catch (Exception e) {
			throw e;
		}
	}

}
