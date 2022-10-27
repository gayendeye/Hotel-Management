package com.saraya.hotelmanagementndeyegaye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDTO {

    private int paymentId;

    private String name;

    private double price;
}
