package com.saraya.hotelmanagementndeyegaye.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @NotBlank(message = "Name may not be blank")
    @Column(unique = true , length = 40)
    @NotEmpty(message = "Try to enter your the name please")
    private String name;

    private double price;
}
