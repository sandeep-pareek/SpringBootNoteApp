package com.sandeep.SpringBootNoteApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.SpringBootNoteApp.model.User;

import java.util.Optional;

public interface UserRepository {
	Optional<User> findByUsername(String username);
}