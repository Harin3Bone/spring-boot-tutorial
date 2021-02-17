package com.tutorial.springboot.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MainService {

	public String getDataService() {
		System.out.println("MainService.java, getDataService()");
		return "MainService.java, getDataService()";
	}

	public Map<String, Object> getDataMapService(String value) {
		System.out.println("MainService.java, getDataMapService()");
		Map<String, Object> res = new LinkedHashMap<>();
		res.put("message", "MainService.java, getDataMapService");
		res.put("value", value);
		return res;
	}

	public Map<String, Object> getCalService(int valA, int valB) {
		Map<String, Object> res = new LinkedHashMap<>();
		res.put("message", "MainService.java, getCalService");
		res.put("value", valA + valB);
		return res;
	}
}
