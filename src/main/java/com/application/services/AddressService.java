package com.application.services;

import com.application.address.Address;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AddressService {

    Optional<Address> findById(int id);

}
