package com.example.backend.mapper;

import com.example.backend.dto.TransactionLogDTO;
import com.example.backend.entity.TransactionLog;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionLogMapper {

    public static TransactionLogDTO toDTO(TransactionLog transactionLog) {
        if (transactionLog == null) {
            return null;
        }

        TransactionLogDTO dto = new TransactionLogDTO();
        dto.setId(transactionLog.getId());
        dto.setTransactionId(transactionLog.getTransaction().getId());
        dto.setStatus(transactionLog.getStatus());
        dto.setLogTimestamp(transactionLog.getLogTimestamp());

        return dto;
    }

    public static List<TransactionLogDTO> toDTOList(List<TransactionLog> transactionLogs) {
        return transactionLogs.stream()
                .map(TransactionLogMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static TransactionLog toEntity(TransactionLogDTO transactionLogDTO) {
        if (transactionLogDTO == null) {
            return null;
        }

        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setStatus(transactionLogDTO.getStatus());
        transactionLog.setLogTimestamp(transactionLogDTO.getLogTimestamp());

        return transactionLog;
    }
}
