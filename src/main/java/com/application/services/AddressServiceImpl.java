package com.application.services;

import com.application.address.Address;
import com.application.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

        private final AddressRepository addressRepository;

        public AddressServiceImpl(AddressRepository addressRepository) {
            this.addressRepository = addressRepository;
        }

    @Override
    public Optional<Address> findById(int id) {
        return addressRepository.findById(id);
    }

}
