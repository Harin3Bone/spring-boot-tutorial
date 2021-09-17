package com.tutorial.log.trace;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/trace")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Log4j2
public class TraceController {

	@GetMapping(value = "")
	public ResponseEntity<Object> testTraceApi() {
		log.info("testTraceApi Begin.");
		log.debug("testTraceApi Debugging-1.");
		log.debug("testTraceApi Debugging-2.");
		log.debug("testTraceApi Debugging-3.");
		
		log.trace("testTraceApi tracing-1");
		log.trace("testTraceApi tracing-2");

		log.info("testTraceApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("TRACE");
	}

	@GetMapping(value = "/error")
	public ResponseEntity<Object> testTraceFoundErrorApi() {
		log.info("testTraceApi Begin.");

		try {
			var x = 0;
			log.debug("testTraceApi debugging x= " + x);

			var y = 1 / x;
			log.debug("testTraceApi debugging y= " + y);
		} catch (Exception e) {
			log.error("testTraceApi " + e.getClass().getSimpleName());
			log.error("testTraceApi " + e.getClass().getSimpleName() + ", message= " + e.getMessage());
			log.trace("testTraceApi " + e.getClass().getSimpleName() + ", trace= " + e.getStackTrace());
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("ERROR " + e.getClass().getSimpleName());
		}

		log.info("testTraceApi Finish.");
		return ResponseEntity.status(HttpStatus.OK).body("TRACE");
	}

}
