package com.sp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.Role;

@Repository
public interface RoleRepositories extends JpaRepository<Role, Integer> {

	Role findByRoleId(int roleId);
	Role findByRole(String role);
	
}
