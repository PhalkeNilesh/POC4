package com.book.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repo;

	@Override
	public List<Book> getBook(Long userId) {
		List<Book> list = this.repo.findAll();
		return list.stream().filter(book -> book.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
