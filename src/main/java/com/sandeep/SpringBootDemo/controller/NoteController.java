package com.sandeep.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandeep.SpringBootDemo.dto.NoteDto;
import com.sandeep.SpringBootDemo.service.NoteService;

/***
 * @author sandeep
 * @since 22 March 2020
 */

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/home")
	@ResponseBody
	public String homepage() {
		return "homes";
	}

	@PostMapping(value = "/addNote")
	@ResponseBody
	public String addNote(@RequestBody NoteDto note){
		System.out.println("note: "+note.toString());
		noteService.addNote(note);
		return "SUCCESS";
	}

	@GetMapping(value = "/getNotes")
	@ResponseBody
	public List<NoteDto> getNotes(){
		System.out.println("Getting all notes");
		return noteService.getNotes();
	}
}
