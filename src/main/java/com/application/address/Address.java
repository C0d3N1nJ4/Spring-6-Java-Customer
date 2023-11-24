package com.application.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    private String id;

    private String street;

    private String number;

    private String suburb;

    private String postalCode;

}
