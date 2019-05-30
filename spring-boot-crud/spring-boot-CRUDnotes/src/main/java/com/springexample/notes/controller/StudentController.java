package com.springexample.notes.controller;

import java.util.List;

import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.notes.model.Note;
import com.springexample.notes.model.Student;
import com.springexample.notes.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		
		return studentRepository.getAllStudents();
		
	}
	
//	@RequestMapping(value ="/createStudent",method = RequestMethod.POST)
//	public Student createStudent(@RequestBody Holder<T> holder) {
//		Student student = new Student();
//		student.setStudentId(holder[0]);
//		
//		Student s= studentRepository.createStudent(student);
//		return s;
//	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable(value="id") int id) {
		Student s = studentRepository.getStudentById(id);
		return s;
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		 Student s=  studentRepository.updateStudent(student);
		 return s;
	}
	
	@DeleteMapping("/deleteStudent")
	public Student deleteStudent(@PathVariable(value = "studentId") int studentId) {
		Student s = studentRepository.deleteStudentById(studentId);
		return s;
	}
	
}
