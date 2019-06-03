package com.springexample.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springexample.notes.model.Note;

public interface NoteJpaRepository extends JpaRepository<Note, Long> {

	Note findByContent(String content);
	List<Note> findByContentLike(String content);
	Note findByContentOrTitle(String content,String title);
	Note findByContentAndTitle(String content,String title);
	Note findByContentIsAndTitleEquals(String content,String title);
	List<Note> findByContentNot(String content);
	
	@Query("select n from Note n where n.content = :contentValue")
	List<Note> queryByContentValue(@Param("contentValue") String contentValue);
}
