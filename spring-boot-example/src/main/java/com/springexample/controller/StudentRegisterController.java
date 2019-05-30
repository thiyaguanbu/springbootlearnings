package com.springexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springexample.beans.Student;
import com.springexample.beans.StudentRegistration;

@Controller
public class StudentRegisterController {
	
	@RequestMapping(method=RequestMethod.POST, value="/register/student")
	public @ResponseBody StudentRegistration registerStudent(@RequestBody Student studentregd) {
		StudentRegistration stdregreply = new StudentRegistration();
		stdregreply.setName(studentregd.getName());
		stdregreply.setAge(studentregd.getAge());
		stdregreply.setRegistrationNumber("12345678");
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
		}

}
