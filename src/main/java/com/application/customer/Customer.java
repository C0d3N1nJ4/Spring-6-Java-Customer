package com.application.customer;

import com.application.address.Address;
import com.application.contact.Contact;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String lastname;
    private String status;

    @OneToOne
    private Address address;

    @OneToOne
    private Contact contact;

   }
