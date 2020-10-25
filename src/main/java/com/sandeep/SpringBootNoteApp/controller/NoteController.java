package com.sandeep.SpringBootNoteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandeep.SpringBootNoteApp.dto.NoteDto;
import com.sandeep.SpringBootNoteApp.service.NoteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/***
 * @author sandeep
 * @since 22 March, 2020
 * @updated 25th Oct, 2020
 * 
 */

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/note/{noteId}")
	@ResponseBody
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public NoteDto getNote(@PathVariable("noteId") int noteId) {
		NoteDto note = noteService.getNote(noteId);
		return note;
	}

	@PostMapping("/note")
	@ResponseBody
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public String saveNote(@RequestBody NoteDto note) {
		System.out.println("note: " + note.toString());
		noteService.saveNote(note);
		return "SUCCESS";
	}

	@PutMapping("/note")
	@ResponseBody
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public NoteDto updateNote(@RequestBody NoteDto note) {
		return noteService.updateNote(note);
	}

	@DeleteMapping("/admin/note/{noteId}")
	@ResponseBody
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public String deleteNote(@PathVariable("noteId") int noteId) {
		noteService.deleteNote(noteId);
		return "SUCCESS";
	}

	@GetMapping("/note/list")
	@ResponseBody
	@ApiOperation(value = "", authorizations = { @Authorization("jwtToken") })
	public List<NoteDto> getNotes() {
		System.out.println("Getting all notes");
		return noteService.getNotes();
	}
}
