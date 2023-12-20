package com.application.contact;

import org.springframework.stereotype.Service;

@Service
public interface ContactService {

Contact create(Contact contact);

boolean existsById(String id);

Contact findById(String id);

Contact update(Contact contact);

void deleteById(String id);

}
