package com.tutorial.log.debug;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/debug")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Log4j2
public class DebugController {

	@GetMapping(value = "")
	public ResponseEntity<Object> testDebugApi() {
		log.info("testDebugApi Begin.");
		log.debug("testDebugApi debugging-1");
		log.debug("testDebugApi debugging-2");
		log.debug("testDebugApi debugging-3");
		
		log.trace("testDebugApi tracing-1");
		log.trace("testDebugApi tracing-2");

		log.info("testDebugApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("DEBUG");
	}

	@GetMapping(value = "/error")
	public ResponseEntity<Object> testDebugFoundErrorApi() {
		log.info("testDebugApi Begin.");

		try {
			var x = 0;
			log.debug("testDebugApi debugging x= " + x);

			var y = 1 / x;
			log.debug("testDebugApi debugging y= " + y);
		} catch (Exception e) {
			log.error("testDebugApi " + e.getClass().getSimpleName());
			log.error("testDebugApi " + e.getClass().getSimpleName() + ", message= " + e.getMessage());
			log.trace("testTraceApi " + e.getClass().getSimpleName() + ", trace= " + e.getStackTrace());
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("ERROR " + e.getClass().getSimpleName());
		}

		log.info("testInfoApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("DEBUG");
	}
}
