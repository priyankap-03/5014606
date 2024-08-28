package com.example.bookstore.dto;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BookDTO {
	private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;
    public Long getId() {
        return id; 
    }

    public void setId(Long id) {
        this.id = id;
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
    
    @SuppressWarnings("serial")
	public abstract class BookDTOSerializer extends StdSerializer<BookDTO> {

        public BookDTOSerializer() {
            this(null);
        }

        @SuppressWarnings("unchecked")
		public BookDTOSerializer(Class<?> vc) {
            super((Class<BookDTO>) vc);
        }

        public BookDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(node.get("id").asLong());
            bookDTO.setTitle(node.get("title").asText());
            bookDTO.setAuthor(node.get("author").asText());
            bookDTO.setPrice(node.get("price").asDouble());
            bookDTO.setIsbn(node.get("isbn").asText());
            return bookDTO;
        }
    }   
}
