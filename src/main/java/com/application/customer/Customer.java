package com.application.customer;

import com.application.address.Address;
import com.application.contact.Contact;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String lastname;
    private String status;

    @OneToOne
    private Address address;

    @OneToOne
    private Contact contact;

    public Customer() {
    }

    public Customer(String id, String name, String lastname, String status, Address address, Contact contact) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.address = address;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
