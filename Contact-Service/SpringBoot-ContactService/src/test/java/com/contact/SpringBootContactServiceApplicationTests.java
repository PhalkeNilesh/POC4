package com.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.contact.model.Contact;
import com.contact.repository.ContactRepository;

@SpringBootTest
class SpringBootContactServiceApplicationTests {
	
	@Autowired
	ContactRepository repo;
	
	
	@Test
	void testAllContact() {
		Iterable<Contact> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
		System.out.println("Success");
	} 
	
	@Test
	public void testContactRead() {
		Contact con = repo.findById(1L).get();
		assertEquals("NIlesh", con.getContactName());
		System.out.println("Success Read");
	}
	
	
	@Test
	void testAddContact() {
		Contact con = new Contact();
		con.setCId(1L);
		con.setContactName("admin");
		con.setEmail("admin@gmail.com");
		con.setUserId(101L);
		assertNotNull(repo.findById(1L).get());
	}
	

	@Test
	void contextLoads() {
	}

}
