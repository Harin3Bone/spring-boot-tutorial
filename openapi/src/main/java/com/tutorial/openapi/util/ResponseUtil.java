package com.tutorial.openapi.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Response")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtil {

	@Schema(name = "description", description = "Response description", example = "success")
	private String description;
	
	@Schema(name = "result", description = "Response object", example = "{}")
	private Object result;
	
}
