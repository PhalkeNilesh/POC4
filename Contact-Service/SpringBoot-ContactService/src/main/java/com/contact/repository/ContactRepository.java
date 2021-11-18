package com.contact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contact.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, Long> {
	

}
