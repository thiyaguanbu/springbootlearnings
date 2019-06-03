package com.sp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.model.User;
import com.sp.repositories.UserRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityExampleApplicationTests {

	@Autowired
	UserRepositories userRepositories;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	@Transactional
	public void testUserWithEmail() {
	
		User user = userRepositories.findByEmail("ttt");
		assertNotNull(user);
		assertEquals("ttt", user.getEmail());
	}

}
