package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiaryDTO {

    private Long id;
    private String accountNumber;
    private String beneficiaryName;
    private String beneficiaryAccountNumber;

    // Lombok will generate getters and setters
}
