package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.model.Contact;
import com.saraya.hotelmanagementndeyegaye.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
@RequestMapping("/api/test/contact")
@CrossOrigin("*")
public class ContactController {

    //INSERT INTO roles(name) VALUES('ROLE_USER');
    //INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
    //INSERT INTO roles(name) VALUES('ROLE_ADMIN');

    @Autowired
    private ContactService mySender;

    public ContactController(ContactService mySender) {
        this.mySender = mySender;
    }

   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> sender (
            @RequestBody Contact message) throws MessagingException {
        return mySender.sender(message.getFrom() ,message.getTo()
                ,message.getSubject()   , message.getText());
    }
}
