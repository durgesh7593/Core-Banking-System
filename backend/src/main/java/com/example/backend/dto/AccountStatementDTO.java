package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AccountStatementDTO {

    private Long id;
    private String accountNumber;
    private LocalDate statementDate;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;

    // Lombok will generate getters and setters
}
