package com.example.bookstoreapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String author;
	    private Double price;
	    private String isbn;
//		public Book(Long id2, String string, String string2, double d, String string3) {
//			// TODO Auto-generated constructor stub
//		}
		public Book(Long id2, String string, String string2, double d, String string3) {
			// TODO Auto-generated constructor stub
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public void setId(long l) {
			// TODO Auto-generated method stub
			
		}
		@Version
		private Integer version;

	

//	public Object getTitle() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setTitle(Object title) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getAuthor() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setAuthor(Object author) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getPrice() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setPrice(Object price) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getIsbn() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setIsbn(Object isbn) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}

}
