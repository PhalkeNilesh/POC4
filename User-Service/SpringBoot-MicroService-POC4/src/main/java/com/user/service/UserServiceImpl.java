package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public User getUser(Long id) {
		
		List<User> list =this.repo.findAll();
		System.out.println(list);
		
		
		return list.stream().filter(user ->user.getUserId().equals(id)).findAny().orElse(null);
	}
	
	

	
//	@Override
//	public User getUser(Long id) {
//		List<User> list = new ArrayList<>();
//		User u1=new User(101l,"Nilesh","Falke","898989","Sonai","414105");
//		User u2=new User(102l,"Sanket","Falke","8889","Sonai","414105");
//		User u3=new User(103l,"Akash","Falke","9090","Sonai","414105");
//		list.add(u1);
//		list.add(u2);
//		list.add(u3);
// 		
//		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
//	}

}
