package com.application.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {

    @Id
    private String id;

    private String email;

    private String phone;

    public Contact(String id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public Contact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
