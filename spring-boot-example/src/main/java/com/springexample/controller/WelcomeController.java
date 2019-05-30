package com.springexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.beans.Welcome;

@RestController
public class WelcomeController {
	
	private static final String message = "Hi Student Mr.%s";

	@RequestMapping(value="/Welcome/user" , method = RequestMethod.GET)
	public Welcome welcomeStudent(@RequestParam(name="name", required=false, defaultValue="Thiyagu") String name) {
		return new Welcome(String.format(message, name));
	}
	
	@RequestMapping("/")
	public String MessageHome() {
		return "It is home page of College Admission";
	}
}
