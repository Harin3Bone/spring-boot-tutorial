package com.tutorial.file.service;

import java.nio.file.FileSystemException;

import org.springframework.web.multipart.MultipartFile;

public interface FileExistService {

	public void saveExistSimpleHandle(MultipartFile file) throws FileSystemException;

	public void saveExistApacheHandle(MultipartFile file) throws FileSystemException;

	public void saveExistGuavaHandle(MultipartFile file) throws FileSystemException;
}
