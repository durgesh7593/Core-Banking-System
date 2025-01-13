package com.example.backend.mapper;

import com.example.backend.dto.TransactionApprovalDTO;
import com.example.backend.entity.TransactionApproval;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionApprovalMapper {

    public static TransactionApprovalDTO toDTO(TransactionApproval transactionApproval) {
        if (transactionApproval == null) {
            return null;
        }

        TransactionApprovalDTO dto = new TransactionApprovalDTO();
        dto.setId(transactionApproval.getId());
        dto.setTransactionId(transactionApproval.getTransaction().getId());
        dto.setAdminId(transactionApproval.getAdmin().getId());
        dto.setApprovalStatus(transactionApproval.getApprovalStatus());
        dto.setApprovalDate(transactionApproval.getApprovalDate());

        return dto;
    }

    public static List<TransactionApprovalDTO> toDTOList(List<TransactionApproval> transactionApprovals) {
        return transactionApprovals.stream()
                .map(TransactionApprovalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static TransactionApproval toEntity(TransactionApprovalDTO transactionApprovalDTO) {
        if (transactionApprovalDTO == null) {
            return null;
        }

        TransactionApproval transactionApproval = new TransactionApproval();
        transactionApproval.setApprovalStatus(transactionApprovalDTO.getApprovalStatus());
        transactionApproval.setApprovalDate(transactionApprovalDTO.getApprovalDate());

        return transactionApproval;
    }
}
