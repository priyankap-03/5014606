package com.example.bookstore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Details about the book")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "The unique ID of the book", example = "1")
	private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Schema(description = "The title of the book", example = "Effective Java")
    private String title;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "The author of the book", example = "Joshua Bloch")
    private String author;

    @NotNull
    @Min(0)
    @Schema(description = "The price of the book", example = "45.99")
    private Double price;

    @NotNull
    @Size(min = 10, max = 13)
    private String isbn;

    @Version
    private Integer version;

	public Book(Long bookId, String string, String string2, double d) {
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Book() {}
    public Book(Long id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
