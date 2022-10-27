package com.saraya.hotelmanagementndeyegaye.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class ContactService {
    @Autowired
    private JavaMailSender mailSender;


    public ResponseEntity<Void> sender(String to , String from ,String subject, String text  ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(text);


        mailSender.send(mimeMessage);
        return null;
    }
}
