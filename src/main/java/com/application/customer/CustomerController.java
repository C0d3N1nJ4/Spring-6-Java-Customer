package com.application.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id);

        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
}
    @GetMapping("/filter/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomerByStatus(@PathVariable("status") String status) {
        return customerRepository.getCustomerByStatus(status);
    }
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}
