package com.sandeep.SpringBootNoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.SpringBootNoteApp.dto.TokenDto;
import com.sandeep.SpringBootNoteApp.dto.UserDto;
import com.sandeep.SpringBootNoteApp.model.AuthenticationRequest;
import com.sandeep.SpringBootNoteApp.service.JSONWebTokenService;
import com.sandeep.SpringBootNoteApp.service.UserService;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 * @modified 3rd Nov 2021
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

	@Autowired
	private JSONWebTokenService jSONWebTokenServices;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/auth")
	public TokenDto generateToken(@RequestBody AuthenticationRequest request) throws Exception {
		System.out.println("test");
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (Exception e) {
			throw new Exception("username or password is invalid");
		}

		String token = jSONWebTokenServices.generateToken(request.getUsername());
		return new TokenDto(token);
	}
}
