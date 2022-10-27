package com.saraya.hotelmanagementndeyegaye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contact")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    private String from;

    private String to;

    private String subject;

    private String text;


}
