package com.sp.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sp.model.Role;
import com.sp.model.User;
import com.sp.repositories.RoleRepositories;
import com.sp.repositories.UserRepositories;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositories userRepositories;
	@Autowired
	RoleRepositories roleRepositories;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	/**
	 * Every user has unique email. This function returns only one User object.
	 */
	
	@Override
	public User findByEmail(String email) {
		User user = userRepositories.findByEmail(email);
		if(null!=user)
			return user;
		
		return null;
	}

	@Override
	public void saveUser(User user) {
		if (null!=user) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			Role userRole = roleRepositories.findByRole("USER");
			user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
			user.setActive("Y");
			userRepositories.saveAndFlush(user);
		}		
	}

	@Override
	public List<User> findAllUser() {
		List<User> users = userRepositories.findAll();
		return users;
	}
	

}
