package com.application.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;

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
        if (customerRepository.existsById(id)) {
            Optional<Customer> result = customerRepository.findById(id);
            return result;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

}

    @PostMapping
    @ResponseBody
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}
