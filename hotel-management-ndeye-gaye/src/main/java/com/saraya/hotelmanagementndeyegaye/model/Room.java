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
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

   private String numberRoom;

    @Column(nullable = false)
    private String name;

    @Column(length = 20)
    private boolean status;

    @Column(length = 14)
    @NotEmpty(message = "Try to enter the number of the room")
    @NotBlank(message = "The number may not be blank")
    private String telRoom;

    private String image;

    private String description;

    private int maxCapacity;


}
