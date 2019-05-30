package com.springexample.notes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springexample.notes.model.Student;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StudentRepositoryImpl implements StudentRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = entityManager.createQuery("select stud from Student stud").getResultList();
		return studentList;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student s = entityManager.find(Student.class, studentId);
		return s;
	}

	@Override
	public Student createStudent(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		Student s = entityManager.find(Student.class, student.getStudentId());
		s.setCollegeId(student.getCollegeId());
		s.setStudentName(student.getStudentName());
		entityManager.persist(s);
		return s;
	}

	@Override
	public Student deleteStudentById(int studentId) {
		Student s = entityManager.find(Student.class, studentId);
		entityManager.remove(s);
		return s;
	}

}
