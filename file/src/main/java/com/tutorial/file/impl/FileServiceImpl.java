package com.tutorial.file.impl;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.file.handler.InvalidFileTypeException;
import com.tutorial.file.service.FileService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FileServiceImpl implements FileService {
	
	@Value("${config.path}")
	private String configRoot;

	private final Path root = Paths.get(configRoot);

	@Override
	public void saveAllFile(MultipartFile file) throws FileSystemException {
		log.info("saveAllFile Begin.");

		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			log.info("saveAllFile Finish.");
		} catch (FileAlreadyExistsException e) {
			log.error("saveAllFile class= FileAlreadyExistsException.");
			log.error("saveAllFile message= " + e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("saveAllFile class= " + e.getClass());
			log.error("saveAllFile message= " + e.getMessage());
		}
	}

	@Override
	public void saveOnlyImageFile(MultipartFile file) throws FileSystemException, InvalidFileTypeException {
		log.info("saveOnlyImageFile Begin.");
		String regex = "(\\bimage)\\/\\w+\\S";

		try {
			if (file.getContentType().matches(regex)) {
				Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			} else {
				log.error("saveOnlyImageFile Error.");
				throw new InvalidFileTypeException("Receive image only.");
			}
			log.info("saveOnlyImageFile Finish.");
		} catch (FileAlreadyExistsException e) {
			log.error("saveOnlyImageFile class= FileAlreadyExistsException.");
			log.error("saveOnlyImageFile message= " + e.getMessage());
			throw e;
		} catch (InvalidFileTypeException e) {
			log.error("saveOnlyImageFile class= InvalidFileTypeException.");
			log.error("saveOnlyImageFile message= " + e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("saveOnlyImageFile class= " + e.getClass());
			log.error("saveOnlyImageFile message= " + e.getMessage());
		}
	}

	@Override
	public void saveWithFolder(MultipartFile file) throws FileSystemException {
		log.info("saveWithFolder Begin.");

		try {
			Path newPath = root.resolve("folder_" + System.currentTimeMillis());
			Files.createDirectories(newPath);
			Files.copy(file.getInputStream(), newPath.resolve(file.getOriginalFilename()));
			log.info("saveWithFolder Finish.");
		} catch (FileAlreadyExistsException e) {
			log.error("saveWithFolder class= FileAlreadyExistsException.");
			log.error("saveWithFolder message= " + e.getMessage());
			throw e;
		} catch (InvalidFileTypeException e) {
			log.error("saveWithFolder class= InvalidFileTypeException.");
			log.error("saveWithFolder message= " + e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("saveWithFolder class= " + e.getClass());
			log.error("saveWithFolder message= " + e.getMessage());
		}
	}
}
