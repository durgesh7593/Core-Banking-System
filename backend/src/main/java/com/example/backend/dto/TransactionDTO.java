package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class TransactionDTO {

    private Long id;
    private String accountNumber;
    private String type;
    private Double amount;
    private LocalDateTime timestamp;
    private String description;

    // Getters and Setters
}
