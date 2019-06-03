package com.springexample.notes.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springexample.notes.model.Note;


@Repository
public interface NoteRepository{
	public List<Note> getAllNotes();
	public Note createNotes(Note note);
	public Note getNote(Long id);
	public Note deleteNote(Long id);
	public Note updateNotes(Note note);
	
	
	
}
