package com.application.customer;

import com.application.address.Address;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private String lastname;
    private String status;

    @OneToOne
    private Address address;

    public Customer() {
    }

    public Customer(int id, String name, String lastname, String status, Address address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
