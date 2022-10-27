package com.saraya.hotelmanagementndeyegaye.dto;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import com.saraya.hotelmanagementndeyegaye.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionistDTO {

    private int receptionistId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneFix;

    private List<GuestDTO> guests;

    private List<PaymentDTO> paymentList;
}
