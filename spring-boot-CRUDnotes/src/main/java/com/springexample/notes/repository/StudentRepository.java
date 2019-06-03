package com.springexample.notes.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springexample.notes.model.Student;

@Repository
public interface StudentRepository {
	
	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	public Student createStudent(Student student);
	public Student updateStudent(Student student);
	public Student deleteStudentById(int studentId);
}
