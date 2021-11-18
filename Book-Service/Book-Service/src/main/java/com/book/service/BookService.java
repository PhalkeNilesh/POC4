package com.book.service;

import java.util.List;

import com.book.model.Book;

public interface BookService {
	
	public List<Book> getBook(Long userId);

}
