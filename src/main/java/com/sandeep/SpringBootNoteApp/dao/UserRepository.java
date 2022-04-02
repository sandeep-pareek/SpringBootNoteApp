package com.sandeep.SpringBootNoteApp.dao;

import java.util.List;
import java.util.Optional;

import com.sandeep.SpringBootNoteApp.model.User;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 * @updated 4th Nov, 2021
 */
public interface UserRepository {
	Optional<User> findByUsername(String username);

	List<User> getAllUsers();
}