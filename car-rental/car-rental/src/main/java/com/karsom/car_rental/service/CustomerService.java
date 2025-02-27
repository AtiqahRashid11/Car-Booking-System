package com.karsom.car_rental.service;

import com.karsom.car_rental.exception.CustomerNotFoundException;
import com.karsom.car_rental.model.Customer;
import com.karsom.car_rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Method to GET all customer list details
    public List<Customer> getAllCustomer() {
        List<Customer> customers = repository.findAll();
        System.out.println("Fetch customers: " + customers);
        return customers;
    }

    // Method to create customer and save in database
    public Customer saveCustomer(Customer customer) {
        System.out.println("Customer information has been stored to the database: " + customer);
        return repository.save(customer);
    }

    // Method for PUT Mapping
    public Customer updateCustomer(int id, Customer customerDetails) {
        return repository.findById(id).map(existingCustomer -> {
            existingCustomer.setFirstName(customerDetails.getFirstName());
            existingCustomer.setLastName(customerDetails.getLastName());
            existingCustomer.setIcNumber(customerDetails.getIcNumber());
            existingCustomer.setGender(customerDetails.getGender());
            existingCustomer.setBirthDate(customerDetails.getBirthDate());
            existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
            existingCustomer.setEmailAddress(customerDetails.getEmailAddress());
            existingCustomer.setHomeAddress(customerDetails.getHomeAddress());
            return repository.save(existingCustomer);
        }).orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
    }

    // Method to delete mapping
    public void deleteCustomer(int id) {
        if (!repository.existsById(id)) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        } else {
            repository.deleteById(id);
        }
    }

}
