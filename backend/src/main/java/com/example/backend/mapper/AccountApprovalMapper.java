package com.example.backend.mapper;

import com.example.backend.dto.AccountApprovalDTO;
import com.example.backend.entity.AccountApproval;

import java.util.List;
import java.util.stream.Collectors;

public class AccountApprovalMapper {

    public static AccountApprovalDTO toDTO(AccountApproval accountApproval) {
        if (accountApproval == null) {
            return null;
        }

        AccountApprovalDTO dto = new AccountApprovalDTO();
        dto.setId(accountApproval.getId());
        dto.setAccountNumber(accountApproval.getAccount().getAccountNumber());
        dto.setAdminId(accountApproval.getAdmin().getId());
        dto.setApprovalStatus(accountApproval.getApprovalStatus());
        dto.setApprovalDate(accountApproval.getApprovalDate());

        return dto;
    }

    public static List<AccountApprovalDTO> toDTOList(List<AccountApproval> accountApprovals) {
        return accountApprovals.stream()
                .map(AccountApprovalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static AccountApproval toEntity(AccountApprovalDTO accountApprovalDTO) {
        if (accountApprovalDTO == null) {
            return null;
        }

        AccountApproval accountApproval = new AccountApproval();
        accountApproval.setApprovalStatus(accountApprovalDTO.getApprovalStatus());
        accountApproval.setApprovalDate(accountApprovalDTO.getApprovalDate());

        return accountApproval;
    }
}
