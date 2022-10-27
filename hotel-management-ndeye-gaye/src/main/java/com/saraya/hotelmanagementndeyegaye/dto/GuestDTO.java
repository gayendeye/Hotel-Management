package com.saraya.hotelmanagementndeyegaye.dto;

import com.saraya.hotelmanagementndeyegaye.model.Reservation;
import com.saraya.hotelmanagementndeyegaye.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDTO {

    private int guestId;

    private String firstName;

    private String lastName;

    private String email;

    private String numberPhone;

    private String address;

    private String city;

    private String country;

    private Room room;

    private Reservation reservation;

}
