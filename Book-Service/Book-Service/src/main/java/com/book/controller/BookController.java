package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookRepository repo;

	@Autowired
	private BookService bookService;

	@GetMapping("/hello")
	public String book() {
		return "Welcome to Book service";
	}

	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return repo.save(book);
	}

	@GetMapping("/getById/{id}")
	public Optional<Book> getById(@PathVariable("id") int id) {
		return repo.findById(id);
	}

	@GetMapping("/getBook")
	public List<Book> getBook() {
		return repo.findAll();
	}

	@GetMapping("/user/{userId}")
	public List<Book> getBookByUserId(@PathVariable("userId") Long userId) {
		return this.bookService.getBook(userId);
	}

}
