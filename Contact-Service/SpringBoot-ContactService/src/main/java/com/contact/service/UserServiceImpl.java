package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.model.Contact;
import com.contact.repository.ContactRepository;

@Service
public class UserServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository repo;

	@Override
	public List<Contact> getContact(Long userId) {
		List<Contact> list = this.repo.findAll();
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}
	
	

	/*
	 * @Override public List<Contact> getContact(Long userId) { List<Contact> list =
	 * new ArrayList<>(); Contact c = new Contact(1L,"nil@gmail.com","Nilesh",101L);
	 * Contact c3 = new Contact(2L,"ni3@gmail.com","Nitin",101L); Contact c1 = new
	 * Contact(2L,"nil@gmail.com","Sanket",102L); Contact c2 = new
	 * Contact(3L,"nil@gmail.com","Akash",103L); list.add(c); list.add(c1);
	 * list.add(c2); list.add(c3); return list.stream().filter(contact ->
	 * contact.getUserId().equals(userId)).collect(Collectors.toList()); }
	 */

}
