package com.sandeep.SpringBootNoteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.SpringBootNoteApp.dto.NoteDto;
import com.sandeep.SpringBootNoteApp.service.NotesService;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Authorization;

/***
 * @author sandeep
 * @since 22 March, 2020
 * @updated 3rd Nov, 2021
 * 
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@GetMapping("/note/{noteId}")
//	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public NoteDto getNote(@PathVariable("noteId") int noteId) {
		NoteDto note = notesService.getNote(noteId);
		return note;
	}

	@PostMapping("/note")
//	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public String saveNote(@RequestBody NoteDto note) {
		System.out.println("note: " + note.toString());
		notesService.saveNote(note);
		return "SUCCESS";
	}

	@PutMapping("/note")
//	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public NoteDto updateNote(@RequestBody NoteDto note) {
		return notesService.updateNote(note);
	}

	@DeleteMapping("/admin/note/{noteId}")
//	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public String deleteNote(@PathVariable("noteId") int noteId) {
		notesService.deleteNote(noteId);
		return "SUCCESS";
	}

	@GetMapping("/note/list")
//	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public List<NoteDto> getNotes() {
		System.out.println("Getting all notes");
		return notesService.getNotes();
	}
}
