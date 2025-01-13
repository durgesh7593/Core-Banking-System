package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountApprovalDTO {

    private Long id;
    private String accountNumber;
    private Long adminId;
    private String approvalStatus;
    private LocalDateTime approvalDate;

    // Lombok will generate getters and setters
}
