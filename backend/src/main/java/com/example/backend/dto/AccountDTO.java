package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDTO {

    private String accountNumber;
    private Long userId;
    private String accountType;
    private Double balance;
    private LocalDateTime createdDate;

    // Getters and Setters
}
