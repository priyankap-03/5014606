package com.example.bookstore.controller;

import com.example.bookstore.model.Customer;
import com.example.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<EntityModel<Customer>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<EntityModel<Customer>> customerModels = customers.stream().map(customer -> {
            EntityModel<Customer> customerModel = EntityModel.of(customer);
            Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel();
            Link allCustomersLink = linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers");
            customerModel.add(selfLink, allCustomersLink);
            return customerModel;
        }).toList();
        return ResponseEntity.ok(customerModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> {
            EntityModel<Customer> customerModel = EntityModel.of(c);
            Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel();
            Link allCustomersLink = linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers");
            customerModel.add(selfLink, allCustomersLink);
            return ResponseEntity.ok(customerModel);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        EntityModel<Customer> customerModel = EntityModel.of(savedCustomer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel();
        Link allCustomersLink = linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers");
        customerModel.add(selfLink, allCustomersLink);
        return customerModel;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Customer>> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        if (!customerService.getCustomerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        EntityModel<Customer> customerModel = EntityModel.of(updatedCustomer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel();
        Link allCustomersLink = linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers");
        customerModel.add(selfLink, allCustomersLink);
        return ResponseEntity.ok(customerModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
