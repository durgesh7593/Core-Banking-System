package com.example.backend.service;

import com.example.backend.dto.AuditLogDTO;
import com.example.backend.entity.AuditLog;
import com.example.backend.entity.User;
import com.example.backend.mapper.AuditLogMapper;
import com.example.backend.repository.AuditLogRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private UserRepository userRepository;

    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO) {
        Optional<User> userOptional = userRepository.findById(auditLogDTO.getAdminId());
        if (userOptional.isPresent() || auditLogDTO.getAdminId() == null) {
            AuditLog auditLog = AuditLogMapper.toEntity(auditLogDTO);
            auditLog.setAdmin(userOptional.orElse(null));
            auditLog = auditLogRepository.save(auditLog);
            return AuditLogMapper.toDTO(auditLog);
        }
        return null;
    }

    public List<AuditLogDTO> getAllAuditLogs() {
        List<AuditLog> auditLogs = auditLogRepository.findAll();
        return AuditLogMapper.toDTOList(auditLogs);
    }

    public Optional<AuditLogDTO> getAuditLogById(Long id) {
        Optional<AuditLog> auditLog = auditLogRepository.findById(id);
        return auditLog.map(AuditLogMapper::toDTO);
    }

    public boolean deleteAuditLog(Long id) {
        Optional<AuditLog> auditLog = auditLogRepository.findById(id);
        if (auditLog.isPresent()) {
            auditLogRepository.delete(auditLog.get());
            return true;
        }
        return false;
    }
}
