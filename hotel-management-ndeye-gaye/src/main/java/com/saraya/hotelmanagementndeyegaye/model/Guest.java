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
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;

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
    private String numberPhone;

    @NotBlank(message = "Address may not be blank")
    @NotEmpty(message = "Try to enter your Address please")
    private String address;

    @NotBlank(message = "City may not be blank")
    @NotEmpty(message = "Try to enter your City please")
    private String city;

    @NotBlank(message = "Country may not be blank")
    @NotEmpty(message = "Try to enter your Country please")
    private String country;

    @OneToOne
    private Room room;

    @OneToOne
    private Reservation reservation;

}
