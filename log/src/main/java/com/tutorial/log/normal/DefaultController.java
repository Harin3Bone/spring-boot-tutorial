package com.tutorial.log.normal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Log4j2
public class DefaultController {

	@GetMapping(value = "/info")
	public ResponseEntity<Object> testInfoApi() {
		log.info("testInfoApi Begin.");
		log.debug("testInfoApi Debugging-1.");
		log.debug("testInfoApi Debugging-2.");
		log.debug("testInfoApi Debugging-3.");

		log.info("testInfoApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("INFO");
	}
	
	@GetMapping(value = "/error")
	public ResponseEntity<Object> testInfoFoundErrorApi() {
		log.info("testInfoApi Begin.");

		try {
			var x = 0;
			log.debug("testInfoApi debugging x= " + x);

			var y = 1 / x;
			log.debug("testInfoApi debugging y= " + y);
		} catch (Exception e) {
			log.error("testInfoApi " + e.getClass().getSimpleName());
			log.error("testInfoApi " + e.getClass().getSimpleName() + ", message= " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("ERROR " + e.getClass().getSimpleName());
		}

		log.info("testInfoApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("DEBUG");
	}
}
