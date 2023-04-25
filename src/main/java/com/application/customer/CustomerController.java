package com.application.customer;
import com.application.exceptions.CustomerNotFoundException;
import com.application.exceptions.StatusNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    private CustomerRepository customerRepository;

    @GetMapping
    @ResponseBody
    @Operation(summary = "Retrieve all customers", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)))
    })
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Retrieve a customer by it's id", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)))
    })
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id);
        } else {
            throw new CustomerNotFoundException(id);
        }
}
    @GetMapping("/filter/{status}")
    @Operation(summary = "Retrieve a customer by status", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)))
    })
    public List<Customer> getCustomerByStatus(@PathVariable("status") String status) {
        if (status == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } else if (status.equals("ACTIVE") || status.equals("INACTIVE")) {
            return customerRepository.getCustomerByStatus(status);
        } else {
            throw new StatusNotFoundException(status);
        }
    }

    @PostMapping
    @ResponseBody
    @Operation(summary = "Create a new customer record", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "202", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)))
    })
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/address/{address-id}")
    @ResponseBody
    @Operation(summary = "Retrieve a customer by address id", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)))
    })
    public Optional<Customer> getCustomerAddress(@PathVariable("address-id") String addressId) {
            return customerRepository.findCustomerByAddress_Id(addressId);
    }

}
