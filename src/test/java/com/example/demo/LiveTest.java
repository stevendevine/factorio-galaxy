package com.example.demo;

import com.example.demo.persistence.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment
		= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LiveTest {

	private static final String API_ROOT
			= "http://localhost:8081/api/books";

	private Book createRandomBook() {
		Book book = new Book();
		book.setTitle("asdf");
		book.setAuthor("author asdf");
		return book;
	}

	@Test
	public void whenGetAllBooks_thenOK() {
		Response response = RestAssured.get(API_ROOT);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

//	private String createBookAsUri(Book book) {
//		Response response = RestAssured.given()
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.body(book)
//				.post(API_ROOT);
//		return API_ROOT + "/" + response.jsonPath().get("id");
//	}
}