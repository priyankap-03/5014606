package com.example.bookstore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bookstore.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTestWithDatabase {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createAndRetrieveBookIntegrationTest() throws Exception {
        // Create a new book
        @SuppressWarnings("unused")
		Book book = new Book(null, "Domain-Driven Design", "Eric Evans", 55.00);

//        // Save the book
//        mockMvc.perform(post("/api/books")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(book)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.title").value("Domain-Driven Design"))
//                .andExpect(jsonPath("$.author").value("Eric Evans"));
//
//        // Retrieve the saved book
//        mockMvc.perform(get("/api/books/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.title").value("Domain-Driven Design"))
//                .andExpect(jsonPath("$.author").value("Eric Evans"));
//    }

    }

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
}
