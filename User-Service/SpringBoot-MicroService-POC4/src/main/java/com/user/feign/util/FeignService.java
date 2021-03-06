package com.user.feign.util;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.model.Book;
import com.user.model.User;

@FeignClient(name = "bookservice", url = "http://localhost:8383/book")
public interface FeignService {

	@GetMapping("/hello")
	public String book();

	@GetMapping("/getById/{id}")
	public Optional<Book> getById(@PathVariable("id") int id);

	@PostMapping("/add")
	public Book addBook(@RequestBody Book book);

	@GetMapping("/getBook")
	public List<Book> getBook();

	@GetMapping("/user/{userId}")
	public List<Book> getBookByUserId(@PathVariable("userId") Long userId);

}