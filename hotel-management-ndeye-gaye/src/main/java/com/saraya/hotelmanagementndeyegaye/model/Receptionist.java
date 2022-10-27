package com.saraya.hotelmanagementndeyegaye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receptionistId;

    @NotBlank(message = "FirstName may not be blank")
    @NotEmpty(message = "Try to enter your firstName please")
    @Column(columnDefinition = "text" , length = 25)
    private String firstName;

    @NotBlank(message = "LastName may not be blank")
    @NotEmpty(message = "Try to enter your lastName please")
    @Column(columnDefinition = "text" , length = 25)
    private String lastName;

    @NotBlank(message = "Email may not be blank")
    @Column(unique = true , length = 40)
    @NotEmpty(message = "Try to enter your lastName please")
    private String email;

    @NotBlank(message = "Number Phone may not be blank")
    @NotEmpty(message = "Try to enter your Number Phone please")
    @Column(length = 14)
    private String phoneFix;

    @OneToMany
    private List<Guest> guests;

    @OneToMany
    private List<Payment> paymentList;




}
