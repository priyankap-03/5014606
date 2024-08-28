package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
