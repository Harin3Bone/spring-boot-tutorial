package com.tutorial.file.service;

import java.nio.file.FileSystemException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	void saveAllFile(MultipartFile file) throws FileSystemException;

	void saveOnlyImageFile(MultipartFile file) throws FileSystemException;

	void saveWithFolder(MultipartFile file) throws FileSystemException;
}
