package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.feign.util.FeignService;
import com.user.model.Book;
import com.user.model.Contact;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FeignService feignService;

	@GetMapping("/hello")
	public String hello() {
		return "Welcome To User Service";
	}

	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		userRepo.save(user);
		return "User Added";
	}

	@GetMapping("/getUsers")
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") Long userId) {
		User user = this.userService.getUser(userId);
		List<Contact> contact = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
		List<Book> book = this.restTemplate.getForObject("http://book-service/book/user/" + user.getUserId(),List.class);
		System.out.println(contact);
		System.out.println(book);
		user.setBook(book);
		user.setBook(book);
		user.setContact(contact);
		return user;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
		return "Book deleted by Id";
	}

//	For Feign client Api 


	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return feignService.addBook(book);
	}

	@GetMapping("/getBook")
	public List<Book> getBook() {
		return feignService.getBook();
	}

	@GetMapping("/getBookById/{id}")
	public Optional<Book> getById(@PathVariable("id") int id) {
		return feignService.getById(id);
	}

	@GetMapping("/user/{userId}")
	public List<Book> getBookByUserId(@PathVariable("userId") Long userId) {
		return feignService.getBookByUserId(userId);
	}

}
