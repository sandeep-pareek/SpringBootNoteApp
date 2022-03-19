package com.sandeep.SpringBootNoteApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandeep.SpringBootNoteApp.model.User;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<User> findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();

		Query<User> query = session.createQuery("from User u where u.username=:username", User.class);
		query.setParameter("username", username);
		User user = query.uniqueResult();
		return Optional.of(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return new ArrayList();
	}

}
