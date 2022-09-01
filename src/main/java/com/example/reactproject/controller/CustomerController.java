package com.example.reactproject.controller;


import com.example.reactproject.exception.ResourceNotFoundException;
import com.example.reactproject.model.Customer;
import com.example.reactproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //get all customer list
    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //create customer rest api
    @PostMapping("/customer/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    // get customer by id rest api
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
        return ResponseEntity.ok(customer);
    }

    //update employee rest api
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        customer.setCustomer_name(customerDetails.getCustomer_name());
        customer.setCustomer_address(customerDetails.getCustomer_address());
        customer.setCustomer_phone(customerDetails.getCustomer_phone());
        Customer updateCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updateCustomer);

    }

    //delete
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
        customerRepository.delete((customer));
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
