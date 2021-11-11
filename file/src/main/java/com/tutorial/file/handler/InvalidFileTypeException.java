package com.tutorial.file.handler;

public class InvalidFileTypeException extends RuntimeException {
	
	private static final long serialVersionUID = -9035636765385380283L;
	
	public InvalidFileTypeException(String msg) {
		super(msg);
	}
	
	public InvalidFileTypeException() {
	}

}
