package com.saraya.hotelmanagementndeyegaye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private String from;

    private String to;

    private String subject;

    private String text;

}
