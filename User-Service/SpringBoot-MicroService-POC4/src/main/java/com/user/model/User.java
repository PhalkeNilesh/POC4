package com.user.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Long userId;
	private String fName;
	private String lName;
	private String phone;
	private String adrress;
	private String pincode;

	private List<Contact> contact = new ArrayList<>();

	private List<Book> book = new ArrayList<>();

	public User(Long userId, String fName, String lName, String phone, String adrress, String pincode) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.adrress = adrress;
		this.pincode = pincode;
	}

}
