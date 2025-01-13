package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionApprovalDTO {

    private Long id;
    private Long transactionId;
    private Long adminId;
    private String approvalStatus;
    private LocalDateTime approvalDate;

    // Lombok will generate getters and setters
}
