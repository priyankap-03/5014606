package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

	
	
	
    @Autowired
    private BookService bookService;

    // Produce and consume both JSON and XML
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public Book getBookById(@PathVariable Long id) {
//        return bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        public ResponseEntity<Book> getBookById11(
                @Parameter(description = "ID of the book to be searched") @PathVariable Long id) {
            Book book = new Book(id, "Effective Java", "Joshua Bloch", 45.99);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
                 produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Book createBook1(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById1(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return null;
    }
    @Operation(summary = "Get book by ID", description = "Returns a book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the book", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Book> createBook11(
            @Parameter(description = "Book object to be created") @RequestBody Book book) {
        book.setId(1L);  // Simulating database save operation with ID generation
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
