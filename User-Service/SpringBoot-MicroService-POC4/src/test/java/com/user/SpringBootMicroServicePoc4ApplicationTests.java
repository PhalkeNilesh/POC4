package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.controller.UserContoller;
import com.user.model.User;
import com.user.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringBootMicroServicePoc4ApplicationTests {

	@Autowired
	UserRepository repo;

	@Autowired
	UserContoller con;

	@Test
	void testAllUser() {
		Iterable<User> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
		System.out.println("Success");
	}

	@Test
	public void testUsesrDelete() {
		repo.deleteById(101L);
		assertThat(repo.existsById(2L)).isFalse();
	}

	@Test
	public void testddUser() {
		User p = new User();
		p.setUserId(101L);
		p.setFName("admin");
		p.setLName("admin");
		p.setAdrress("pune");
		p.setPincode("411414");
		p.setPhone("99999999");
		assertNotNull(repo.findById(101L).get());
	}

	@Test
	void contextLoads() {
	}

}
