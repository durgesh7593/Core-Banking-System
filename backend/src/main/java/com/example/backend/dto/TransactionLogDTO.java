package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionLogDTO {

    private Long id;
    private Long transactionId;
    private String status;
    private LocalDateTime logTimestamp;

    // Lombok will generate getters and setters
}
