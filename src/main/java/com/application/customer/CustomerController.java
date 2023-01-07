package com.application.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id);
}

    @PostMapping
    @ResponseBody
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}
