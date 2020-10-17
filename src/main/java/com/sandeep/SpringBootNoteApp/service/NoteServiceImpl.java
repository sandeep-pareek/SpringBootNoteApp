package com.sandeep.SpringBootNoteApp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.SpringBootNoteApp.dao.NoteDao;
import com.sandeep.SpringBootNoteApp.dto.NoteDto;
import com.sandeep.SpringBootNoteApp.model.Note;
import com.sandeep.SpringBootNoteApp.model.Tag;

/***
 * @author Sandeep Pareek
 * @since 22 March, 2020
 * @updated 12 April, 2020
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private ModelMapper modelMapper;


	@Transactional
	public NoteDto getNote(int noteId) {
		try {
			Note note = noteDao.getNote(noteId);
			return modelMapper.map(note, NoteDto.class);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public NoteDto saveNote(NoteDto note) {
		try {
			Note n = modelMapper.map(note, Note.class);
			noteDao.saveNote(n);
			return note;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public NoteDto updateNote(NoteDto note) {
		Note n = noteDao.getNote(note.getId());
		n.setDescription(note.getDescription());
		n.setTitle(note.getTitle());
		n.setStatus(note.getStatus());
		Map<Integer, Tag> tagDtos = n.getTags().stream().collect(Collectors.toMap(Tag::getTagId, t-> t));
		List<Tag> tagList = note.getTags()
				.stream()
				.map(t -> {
					Tag tag = tagDtos.getOrDefault(t.getTagId(), new Tag());
					if(tag.getTagId() != null) {
						tag.setTagId(t.getTagId());
					}
					tag.setTagName(t.getTagName());
					return tag;
				})
				.collect(Collectors.toList());

		n.setTags(tagList);
		return modelMapper.map(noteDao.updateNote(n), NoteDto.class);
	}

	@Transactional
	public List<NoteDto> getNotes() {
		return noteDao
				.getNotes()
				.parallelStream()
				.map(n -> modelMapper.map(n, NoteDto.class))
				.collect(Collectors.toList());
	}

	@Transactional
	public void deleteNote(int noteId) {
		noteDao.deleteNote(noteId);
		
	}
}
