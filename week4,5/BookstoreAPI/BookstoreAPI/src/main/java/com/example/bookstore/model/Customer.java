package com.example.bookstore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Email
    private String email;

    @Version
    private Integer version;

	

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}



	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and Setters
}
