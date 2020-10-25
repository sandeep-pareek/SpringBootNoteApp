package com.sandeep.SpringBootNoteApp.dao;

import java.util.Optional;

import com.sandeep.SpringBootNoteApp.model.User;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 */
public interface UserRepository {
	Optional<User> findByUsername(String username);
}