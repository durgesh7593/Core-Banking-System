package com.example.backend.mapper;

import com.example.backend.dto.AuditLogDTO;
import com.example.backend.entity.AuditLog;

import java.util.List;
import java.util.stream.Collectors;

public class AuditLogMapper {

    public static AuditLogDTO toDTO(AuditLog auditLog) {
        if (auditLog == null) {
            return null;
        }

        AuditLogDTO dto = new AuditLogDTO();
        dto.setId(auditLog.getId());
        dto.setEventType(auditLog.getEventType());
        dto.setEventTimestamp(auditLog.getEventTimestamp());
        dto.setAccountNumber(auditLog.getAccountNumber());
        dto.setDescription(auditLog.getDescription());
        dto.setAdminId(auditLog.getAdmin() != null ? auditLog.getAdmin().getId() : null);

        return dto;
    }

    public static List<AuditLogDTO> toDTOList(List<AuditLog> auditLogs) {
        return auditLogs.stream()
                .map(AuditLogMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static AuditLog toEntity(AuditLogDTO auditLogDTO) {
        if (auditLogDTO == null) {
            return null;
        }

        AuditLog auditLog = new AuditLog();
        auditLog.setId(auditLogDTO.getId());
        auditLog.setEventType(auditLogDTO.getEventType());
        auditLog.setEventTimestamp(auditLogDTO.getEventTimestamp());
        auditLog.setAccountNumber(auditLogDTO.getAccountNumber());
        auditLog.setDescription(auditLogDTO.getDescription());

        return auditLog;
    }
}
