package com.saraya.hotelmanagementndeyegaye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;


    @Column(columnDefinition = "date")
    private LocalDate dateInn;

    @Column(columnDefinition = "date")
    private LocalDate dateOut;

    private int numberPerson;

   // @OneToMany
    @OneToOne
    private Room room;
    //@JoinColumn(name="roomId" , referencedColumnName = "roomId")
    //private List<Room> roomList;

    @OneToOne()
    @JoinColumn(name = "guestId" , referencedColumnName = "guestId")
    private Guest guest;
}
