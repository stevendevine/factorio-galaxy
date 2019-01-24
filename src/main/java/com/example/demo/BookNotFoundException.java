package com.example.demo;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(long id) {
		super("book id "+id+" not found");
	}
}