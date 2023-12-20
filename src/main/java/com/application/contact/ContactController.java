package com.application.contact;

import com.application.exceptions.ContactNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactServiceImpl contactService;


    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable String id) {
        if (contactService.existsById(id)) {
            return contactService.findById(id);
        } else {
            throw new ContactNotFoundException(id);
        }
    }


}
