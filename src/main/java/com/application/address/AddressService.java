package com.application.address;

import com.application.address.Address;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AddressService {

    Optional<Address> findById(String id);

    Address create(Address address);

}
