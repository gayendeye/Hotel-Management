package com.saraya.hotelmanagementndeyegaye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private int roomId;

    private String numberRoom;

    private String name;

    private Boolean status;

    private String telRoom;

    private String image;

    private String description;

    private int maxCapacity;

}
