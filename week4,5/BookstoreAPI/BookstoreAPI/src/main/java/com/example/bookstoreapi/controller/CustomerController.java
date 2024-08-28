package com.example.bookstoreapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bookstoreapi.entity.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepository;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String name,
                                                     @RequestParam String email,
                                                     @RequestParam String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);

        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}
