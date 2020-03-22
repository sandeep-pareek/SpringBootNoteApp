package com.sandeep.SpringBootDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandeep.SpringBootDemo.model.Note;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/***
 * @author sandeep
 * @since 22 March 2020
 */

@Repository
public class NoteDaoImpl implements NoteDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addNote(Note note) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(note);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Note> getNotes(){
		List<Note> list = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();

			// Create CriteriaBuilder
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Note> criteria = builder.createQuery(Note.class);
			Root<Note> root = criteria.from(Note.class);
			criteria.select(root);

			Query<Note> q = session.createQuery(criteria);

			list = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
