package com.tutorial.file.impl;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.file.service.FileService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FileServiceImpl implements FileService {

	private final Path root = Paths.get("uploads");

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
	public void saveImgFile(MultipartFile file) {
		log.info("saveImgFile Begin.");

		try {
			log.info("saveImgFile Finish.");
		} catch (Exception e) {
			log.error("saveImgFile class= " + e.getClass());
			log.error("saveImgFile message= " + e.getMessage());
		}
	}

	@Override
	public void saveMediaFile(MultipartFile file) {
		log.info("saveMediaFile Begin.");

		try {
			log.info("saveMediaFile Finish.");
		} catch (Exception e) {
			log.error("saveMediaFile class= " + e.getClass());
			log.error("saveMediaFile message= " + e.getMessage());
		}
	}

}
