package com.example.bookstoreapi.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bookstoreapi.entity.Book;
@RestController
@RequestMapping("/books")
public class BookControllerWithHeaders {

    // Example: Create a new book with custom headers
    @PostMapping("/with-headers")
    public ResponseEntity<Book> createBookWithHeaders(@RequestBody Book book) {
        // Save the book to the database (mocking this part)
        book.setId(1L);

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Created new book");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    // Example: Fetch a book with custom headers
    @GetMapping("/{id}/with-headers")
    public ResponseEntity<Book> getBookWithHeaders(@PathVariable Long id) {
        // Fetch the book from the database (mocking this part)
        Book book = new Book(id, "Sample Title", "Sample Author", 19.99, "1234567890");

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Fetched book details");

        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }
}
