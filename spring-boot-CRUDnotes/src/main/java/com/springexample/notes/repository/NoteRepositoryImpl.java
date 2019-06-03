package com.springexample.notes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springexample.notes.model.Note;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class NoteRepositoryImpl implements NoteRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Note> getAllNotes() {
		return entityManager.createQuery("select note from Note note").getResultList();
	}

	@Override
	public Note createNotes(Note note) {
		entityManager.persist(note);
		return note;
	}

	@Override
	public Note getNote(Long id) {
		return entityManager.find(Note.class, id);
	}

	@Override
	public Note deleteNote(Long id) {
		Note note = entityManager.find(Note.class, id);
		entityManager.remove(note);
		return note;
	}

	@Override
	public Note updateNotes(Note note) {
	Note noteToUpdate = entityManager.find(Note.class, note.getId());
	noteToUpdate.setContent(note.getContent());
	noteToUpdate.setTitle(note.getTitle());
	entityManager.persist(noteToUpdate);
		return noteToUpdate;
	}

	
	
	

}
