package com.tutorial.file.handler;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OverallHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> globalHandler() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR.");
	}

	@ExceptionHandler(value = { FileSystemException.class, FileAlreadyExistsException.class,
			FileNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> fileHandler() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FILE_EXCEPTION.");
	}

	@ExceptionHandler(value = InvalidFileTypeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> invalidFileHelper(InvalidFileTypeException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("NOT_IMAGE_EXCEPTION.");
	}
}
