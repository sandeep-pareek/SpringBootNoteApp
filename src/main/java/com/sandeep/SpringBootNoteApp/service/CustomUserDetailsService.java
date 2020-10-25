package com.sandeep.SpringBootNoteApp.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.SpringBootNoteApp.dao.UserRepositoryImpl;
import com.sandeep.SpringBootNoteApp.model.CustomUserDetails;
import com.sandeep.SpringBootNoteApp.model.User;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepositoryImpl userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("User is not found in our system: " + username));

		return user.map(CustomUserDetails::new).get();
	}
}