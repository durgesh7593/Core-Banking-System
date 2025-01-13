package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditLogDTO {

    private Long id;
    private String eventType;
    private LocalDateTime eventTimestamp;
    private String accountNumber;
    private String description;
    private Long adminId;

    // Lombok will generate getters and setters
}
