package com.saraya.hotelmanagementndeyegaye.dto;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import com.saraya.hotelmanagementndeyegaye.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

     private int reservationId;

     private String dateInn;

     private String dateOut;

     private int numberPerson;

     private Room room;

   //  private List<Room> roomList;

     private GuestDTO guest;
}
