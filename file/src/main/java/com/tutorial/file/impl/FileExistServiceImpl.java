package com.tutorial.file.impl;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tutorial.file.handler.InvalidFileTypeException;
import com.tutorial.file.service.FileExistService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FileExistServiceImpl implements FileExistService {

	@Value("${config.path}")
	private String configRoot;

	private final Path root = Paths.get(configRoot);

	@Override
	public void saveExistSimpleHandle(MultipartFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveExistApacheHandle(MultipartFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveExistGuavaHandle(MultipartFile file) throws FileSystemException {
		log.info("saveExistGuavaHandle Begin.");

		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			log.info("saveExistGuavaHandle Finish.");
		} catch (FileAlreadyExistsException e) {
			log.error("saveExistGuavaHandle File already exist.");
			String extension = com.google.common.io.Files.getFileExtension(file.getOriginalFilename());
			String fileName = com.google.common.io.Files.getNameWithoutExtension(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(),
						this.root.resolve(fileName + "_" + System.currentTimeMillis() + "." + extension));
			} catch (IOException e1) {
				throw new FileSystemException("Something error, Please contact admin.");
			} finally {
				log.info("saveExistGuavaHandle Finish.");
			}
		} catch (InvalidFileTypeException e) {
			log.error("saveExistGuavaHandle class= InvalidFileTypeException.");
			log.error("saveExistGuavaHandle message= " + e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("saveExistGuavaHandle class= " + e.getClass());
			log.error("saveExistGuavaHandle message= " + e.getMessage());
		}

	}

}
