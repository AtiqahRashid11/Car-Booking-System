package com.karsom.car_rental.controller;

import com.karsom.car_rental.model.Customer;
import com.karsom.car_rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Customer> getAllCustomer() {
        return service.getAllCustomer();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = service.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer created successfully with ID: " + savedCustomer.getUserId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        Customer updatedCustomer = service.updateCustomer(id, customerDetails);
        return ResponseEntity.ok("Customer updated successfully with ID: " + updatedCustomer.getUserId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully with ID: " + id);
    }
}
