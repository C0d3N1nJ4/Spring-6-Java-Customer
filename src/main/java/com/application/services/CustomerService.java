package com.application.services;

import com.application.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> findAll();

    boolean existsById(int id);

    Optional<Customer> findById(int id);

    List<Customer> getCustomerByStatus(String status);

    Customer save(Customer customer);

    Optional<Customer> findCustomerByAddress_Id(String addressId);
}
