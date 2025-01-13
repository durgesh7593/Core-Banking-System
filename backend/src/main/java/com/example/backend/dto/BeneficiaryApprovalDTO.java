package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BeneficiaryApprovalDTO {

    private Long id;
    private Long beneficiaryId;
    private Long adminId;
    private String approvalStatus;
    private LocalDateTime approvalDate;

    // Lombok will generate getters and setters
}
