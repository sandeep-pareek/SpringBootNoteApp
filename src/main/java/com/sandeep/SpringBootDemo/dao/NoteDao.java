package com.sandeep.SpringBootDemo.dao;

import java.util.List;

import com.sandeep.SpringBootDemo.model.Note;

/***
 * @author sandeep
 * @since 22 March 2020
 */

public interface NoteDao {
	public void addNote(Note note);
	
	public List<Note> getNotes();

}
