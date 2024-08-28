package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id) {
        Book book = new Book(id, "Sample Title", "Sample Author", 19.99, "1234567890");
        return book;
        
    }
    @GetMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND) // Sets the status to 404 Not Found
    public void bookNotFound() 
    {
    	
    }
    @GetMapping("/search")
    public List<Book> getBooksByTitleOrAuthor(@RequestParam(required = false) String title,
                                              @RequestParam(required = false) String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleContainingAndAuthorContaining(title, author);
        } else if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null) {
            return bookRepository.findByTitleContaining(author);
        } else {
            return bookRepository.findAll();
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
    	book.setId(1L);
    	return book;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPrice(updatedBook.getPrice());
                    book.setIsbn(updatedBook.getIsbn());
                    return ResponseEntity.ok(bookRepository.save(book));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
