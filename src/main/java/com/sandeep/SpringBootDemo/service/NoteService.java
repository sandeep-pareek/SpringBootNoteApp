package com.sandeep.SpringBootDemo.service;

import java.util.List;

import com.sandeep.SpringBootDemo.dto.NoteDto;

/***
 * @author sandeep
 * @since 22 March 2020
 */

public interface NoteService {

	public void addNote(NoteDto note);

	public NoteDto updateNote(NoteDto note);

	public List<NoteDto> getNotes();

	public NoteDto getNote(int noteId);
}
