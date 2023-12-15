package com.application.customer;

import com.application.address.Address;
import com.application.contact.Contact;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
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

    public Customer(String id, String name, String lastname, String status, Address address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.address = address;
    }

    public Customer(String id, String name, String lastname, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name= name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


}