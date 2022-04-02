package com.sandeep.SpringBootNoteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.SpringBootNoteApp.dto.UserDto;
import com.sandeep.SpringBootNoteApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController()
public class UserController {


	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public String signup(@RequestBody UserDto user) throws Exception {
		
		try {
			userService.getUsers();
		} catch(Exception e) {
			throw new Exception("Sign up failed!");
		}

		return "success";
	}
	
	@GetMapping
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public List<UserDto> getAllUsers() {
		return userService.getUsers();
	}
	
}
