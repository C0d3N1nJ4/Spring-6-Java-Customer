package com.application.services;

import com.application.customer.Customer;
import com.application.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean existsById(int id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getCustomerByStatus(String status) {
        return customerRepository.getCustomerByStatus(status);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerByAddress_Id(String addressId) {
        return customerRepository.findCustomerByAddress_Id(addressId);
    }


}
