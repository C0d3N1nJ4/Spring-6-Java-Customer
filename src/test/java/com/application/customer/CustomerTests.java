package com.application.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
