package com.springexample.notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springexample.notes.model.Note;
import com.springexample.notes.repository.NoteJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCruDnotesApplicationTests {

	@Autowired
	NoteJpaRepository noteJpaRepository;
		
	@Test
	@Transactional
	public void contextLoads() {
		
		
	}
	@Test
	@Transactional
	public void testGetAndSaveAndDelete() {
		
		Note note = new Note();
		note.setContent("ApacheCamel");
		note.setTitle("Routing DSL");
		//save notes
		noteJpaRepository.saveAndFlush(note);
		//get note
		Note note2 = noteJpaRepository.findById(note.getId()).get();
		assertEquals("ApacheCamel", note.getContent());
		//delete
		
		noteJpaRepository.delete(note2);
		
	}
	
	@Test
	@Transactional
	public void testFindBy() {
		//Note note = noteJpaRepository.findByContent("spring boot and restful web services");
		List<Note> notes = noteJpaRepository.findByContentNot("spring boot and restful web services");
		
		assertNotNull(notes);
		//assertNotSame("spring notes2", notes.get(0).getContent());
		
		
		
		assertEquals("spring notes", notes.get(0).getContent());
	}
	
	
	@Test
	@Transactional
	public void testFindByContent() {
		Note note = noteJpaRepository.findByContentOrTitle("spring notes", " note");
		
		assertNotNull(note);
		
		assertEquals("spring notes", note.getContent());
	}
	
	
	@Test
	@Transactional
	public void testFindwithLike() {
		List<Note> notes = noteJpaRepository.findByContentLike("spring%");
		
		assertNotNull(notes);
		
		assertEquals(3, notes.size());
	}
	
	@Test
	@Transactional
	public void testQueryByMethod() {
		List<Note> notes = noteJpaRepository.queryByContentValue("spring notes");
		assertNotNull(notes);
		assertEquals("spring notes", notes.get(0).getContent());
	}
	

}
