package com.sp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.User;

@Repository("UserRepositories")
public interface UserRepositories extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
