package com.book.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.netflix.discovery.provider.Serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	private int id;
	private String bookName;
	private String bookAuthor;
	private Long userId;

}
