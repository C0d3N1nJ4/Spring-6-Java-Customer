package com.application.address;

import com.application.address.Address;
import com.application.address.AddressRepository;
import com.application.address.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

        private final AddressRepository addressRepository;

        public AddressServiceImpl(AddressRepository addressRepository) {
            this.addressRepository = addressRepository;
        }

    @Override
    public Optional<Address> findById(String id) {
        var address = addressRepository.findById(id);
        if (address.isPresent()) {
            return address;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

}
