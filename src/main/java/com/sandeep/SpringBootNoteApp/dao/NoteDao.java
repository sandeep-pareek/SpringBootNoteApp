package com.sandeep.SpringBootNoteApp.dao;

import java.util.List;

import com.sandeep.SpringBootNoteApp.model.Note;

/***
 * @author sandeep
 * @since 22 March 2020
 */

public interface NoteDao {
	public void saveNote(Note note);

	public List<Note> getNotes();

	public Note updateNote(Note note);

	public Note getNote(Integer noteId);

	public void deleteNote(int noteId);
}
