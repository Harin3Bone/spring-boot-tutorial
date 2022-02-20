package com.tutorial.authorize.service;

public interface AuthenService {
	
	boolean authorization(String username, String password);
	
	String requestToken();
}
