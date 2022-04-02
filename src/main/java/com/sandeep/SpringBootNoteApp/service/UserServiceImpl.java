package com.sandeep.SpringBootNoteApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.SpringBootNoteApp.dao.UserRepository;
import com.sandeep.SpringBootNoteApp.dto.NoteDto;
import com.sandeep.SpringBootNoteApp.dto.UserDto;
import com.sandeep.SpringBootNoteApp.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto saveUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<UserDto> getUsers() {
		return userRepository.getAllUsers()
				.parallelStream()
				.map(u -> modelMapper.map(u, UserDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public UserDto getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

}
