package com.sp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sp.model.User;
import com.sp.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registraion() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("registration");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findByEmail(user.getEmail());
		if(null!=userExists) {
			bindingResult
				.rejectValue("email", "error.user", "There is already a user registered with the email provided");
		}
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		}
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home",method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ModelAndView getAllUsers() {
		ModelAndView model = new ModelAndView();
		List<User> userList = userService.findAllUser();
		model.addObject("users", userList);
		model.setViewName("registrationSuccess");
		return model;
		
	}
	
}
