package com.sandeep.SpringBootDemo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandeep.SpringBootDemo.dto.NoteDto;
import com.sandeep.SpringBootDemo.service.NoteService;

/***
 * @author sandeep
 * @since 22 March, 2020
 * @updated 29 March, 2020
 * 
 */

@Controller
@RequestMapping("/note")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping("/")
	@ResponseBody
	public String saveNote(@RequestBody NoteDto note) {
		System.out.println("note: " + note.toString());
		noteService.saveNote(note);
		return "SUCCESS";
	}

	@PutMapping("/")
	@ResponseBody
	public NoteDto updateNote(@RequestBody NoteDto note) {
		return noteService.updateNote(note);
	}

	@GetMapping("/{noteId}")
	@ResponseBody
	public NoteDto getNote(@PathVariable("noteId") int noteId) {
		NoteDto note = noteService.getNote(noteId);
		return note;
	}

	@DeleteMapping("/{noteId}")
	@ResponseBody
	public String deleteNote(@PathVariable("noteId") int noteId) {
		noteService.deleteNote(noteId);
		return "SUCCESS";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<NoteDto> getNotes() {
		System.out.println("Getting all notes");
		return noteService.getNotes();
	}
}
