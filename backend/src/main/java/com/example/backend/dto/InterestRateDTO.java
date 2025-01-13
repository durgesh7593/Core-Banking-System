package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterestRateDTO {

    private Long id;
    private String accountType;
    private Double interestRate;

    // Lombok will generate getters and setters
}
