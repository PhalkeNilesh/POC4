package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.repository.ContactRepository;
import com.contact.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactRepository contactRepo;

//	@GetMapping("/hello")
//	public String hello() {
//		return "Welcome To Contact Service";
//	}
	
	@PostMapping("/save")
	public Contact addContact(@RequestBody Contact contact) {
		return contactRepo.save(contact);
	}

	@GetMapping("/getContact")
	public List<Contact> allContact() {
		return contactRepo.findAll();
	}
	
	@GetMapping("/user/{userId}")
	public List<Contact> getContact(@PathVariable("userId") Long userId) {
		return this.contactService.getContact(userId);
	}

	

	
}
