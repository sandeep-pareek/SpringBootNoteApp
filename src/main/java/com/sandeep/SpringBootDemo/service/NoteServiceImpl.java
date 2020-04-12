package com.sandeep.SpringBootDemo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.SpringBootDemo.dao.NoteDao;
import com.sandeep.SpringBootDemo.dto.NoteDto;
import com.sandeep.SpringBootDemo.model.Note;
import com.sandeep.SpringBootDemo.model.Tag;

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
	public void saveNote(NoteDto note) {
		try {
			Note n = modelMapper.map(note, Note.class);
			noteDao.saveNote(n);
		} catch(Exception e) {
			e.printStackTrace();
		}
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
				.filter(t -> tagDtos.get(t.getTagId()) != null)
				.map(t -> {
					Tag tag = tagDtos.get(t.getTagId());
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
