package com.sandeep.SpringBootNoteApp.service;

import java.util.List;

import com.sandeep.SpringBootNoteApp.dto.UserDto;

public interface UserService {

	public UserDto saveUser(UserDto user);

//	public UserDto updateUser(UserDto user);

	public List<UserDto> getUsers();

	public UserDto getUser(int userId);

	public void deleteUser(int userId);
}
