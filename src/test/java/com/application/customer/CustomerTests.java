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
    public void saveNewCustomer() {
        System.out.println(customerRepository.save(new Customer(1, "NAIOMI")));
        System.out.println(customerRepository.save(new Customer(2, "EWALD")));
        System.out.println(customerRepository.save(new Customer(3, "TEYTE")));
    }

    @Test
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
