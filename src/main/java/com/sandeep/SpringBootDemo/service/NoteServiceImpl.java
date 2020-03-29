package com.sandeep.SpringBootDemo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.SpringBootDemo.dao.NoteDao;
import com.sandeep.SpringBootDemo.dto.NoteDto;
import com.sandeep.SpringBootDemo.model.Note;

/***
 * @author sandeep
 * @since 22 March 2020
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void addNote(NoteDto note) {
		noteDao.addNote(modelMapper.map(note, Note.class));
	}

	@Transactional
	public NoteDto updateNote(NoteDto note) {
		Note n = noteDao.getNote(note.getId());
		n.setDescription(note.getDescription());
		n.setTitle(note.getTitle());
		n.setStatus(note.getStatus());
		n.setLastUpdatedDate(note.getLastUpdatedDate());
		return modelMapper.map(noteDao.updateNote(n), NoteDto.class);
	}

	@Transactional
	public NoteDto getNote(int noteId) {
		Note note = noteDao.getNote(noteId);
		return modelMapper.map(note, NoteDto.class);
	}

	@Transactional
	public List<NoteDto> getNotes() {
		return modelMapper.map(noteDao.getNotes(), List.class);
	}
}
