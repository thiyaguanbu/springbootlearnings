package com.springexample.notes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.pringexample.notes.repository.NoteRepositoryImpl;
import com.springexample.notes.model.Note;
import com.springexample.notes.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		
		return noteRepository.getAllNotes();
	}
	
	@PostMapping("/notes")
	public Note createNotes(@Valid @RequestBody Note note) {
		return noteRepository.createNotes(note);
	}
	
	//get Note by id
	
	@GetMapping("/notes/{id}")
	public Note getNote(@PathVariable(value="id") Long noteId) {
		return noteRepository.getNote(noteId);
	}
	
	@DeleteMapping("/note/{id}")
	public Note deleteNote(@PathVariable(value = "id") Long noteId) {
		return noteRepository.deleteNote(noteId);
	}
	
	@PutMapping("/notes")
	public Note updateNote(@Valid @RequestBody Note note) {
		return noteRepository.updateNotes(note);
	}
	
}
