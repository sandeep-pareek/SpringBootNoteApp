package com.sandeep.SpringBootNoteApp.service;

import java.util.List;

import com.sandeep.SpringBootNoteApp.dto.NoteDto;

/***
 * @author sandeep
 * @since 22 March 2020
 */

public interface NotesService {

	public NoteDto saveNote(NoteDto note);

	public NoteDto updateNote(NoteDto note);

	public List<NoteDto> getNotes();

	public NoteDto getNote(int noteId);

	public void deleteNote(int noteId);
}
