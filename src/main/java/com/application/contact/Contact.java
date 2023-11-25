package com.application.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    private String id;

    private String email;

    private String phone;
}
