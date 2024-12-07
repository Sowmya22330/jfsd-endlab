package com.example.demo;


import com.example.demo.Customer;
import repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer updateCustomer(Long id, String name, String address) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Customer not found with ID: " + id));
        customer.setName(name);
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}
