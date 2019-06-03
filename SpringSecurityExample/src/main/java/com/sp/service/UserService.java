package com.sp.service;

import java.util.List;

import com.sp.model.User;

public interface UserService {
	
	User findByEmail(String email);
	void saveUser(User user);
	List<User> findAllUser();

}
