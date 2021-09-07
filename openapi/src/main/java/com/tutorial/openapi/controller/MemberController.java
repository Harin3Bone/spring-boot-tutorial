package com.tutorial.openapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.openapi.entity.MemberEntity;
import com.tutorial.openapi.impl.MemberServiceImpl;
import com.tutorial.openapi.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Member")
@RestController
@RequestMapping(value = "/member")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MemberController {

	@Autowired
	MemberServiceImpl memberService;

	@Operation(summary = "Get All Member")
	@GetMapping(value = "")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUtil.class))) })
	@ResponseBody
	public ResponseUtil getAllMember() {
		var res = memberService.getAllMember();
		return new ResponseUtil("Get all member success.", res);
	}

	@Operation(summary = "Get All Member [Authorization]", security = {
			@SecurityRequirement(name = "Authorization")
	})
	@Parameters(value = {
			@Parameter(name = "Authorization", description = "Authorization token", example = "Token", in = ParameterIn.HEADER) })
	@GetMapping(value = "/auth")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUtil.class))) })
	@ResponseBody
	public ResponseUtil getAllMemberWithAuthorize(@RequestHeader(name = "Authorization", required = true) String auth) {
		var res = memberService.getAllMember();
		return new ResponseUtil("Get all member success.", res);
	}

	@Operation(summary = "Get Member by ID [PATH]")
	@Parameters(value = { @Parameter(name = "id", description = "Member ID", example = "1", in = ParameterIn.PATH) })
	@GetMapping(value = "/path/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil getAllMemberByIdPath(@PathVariable(name = "id") long id) {
		var res = memberService.getMemberById(id);
		return new ResponseUtil("Get member by id success.", res);
	}

	@Operation(summary = "Get Member by ID [QUERY]")
	@Parameters(value = { @Parameter(name = "id", description = "Member ID", example = "1", in = ParameterIn.QUERY) })
	@GetMapping(value = "/query")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil getAllMemberByIdQuery(@RequestParam(name = "id") long id) {
		var res = memberService.getMemberById(id);
		return new ResponseUtil("Get member by id success.", res);
	}

	@Operation(summary = "Create member")
	@PostMapping(value = "")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public ResponseUtil createMember(@RequestBody MemberEntity body) {
		memberService.createMember(body);
		return new ResponseUtil("Create member success.", new HashMap<String, String>());
	}

	@Operation(summary = "Update member")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"id\": 1,\"name\": \"Harin\",\"job\": \"Fullstack Developer\",\"lang\": \"Kotlin\"}")))
	@PutMapping(value = "")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil updateMember(@RequestBody MemberEntity body) {
		memberService.updateMember(body);
		var res = memberService.getMemberById(body.getId());
		return new ResponseUtil("Update member success.", res);
	}

	@Operation(summary = "Delete member")
	@Parameters(value = { @Parameter(name = "id", description = "Member ID", example = "1", in = ParameterIn.PATH) })
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public ResponseUtil deleteAllMemberById(@PathVariable(name = "id") long id) {
		memberService.deleteMemberById(id);
		return new ResponseUtil("Delete member success.", new HashMap<String, String>());
	}

}
