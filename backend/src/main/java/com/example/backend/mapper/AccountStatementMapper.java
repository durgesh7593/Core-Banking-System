package com.example.backend.mapper;

import com.example.backend.dto.AccountStatementDTO;
import com.example.backend.entity.AccountStatement;

import java.util.List;
import java.util.stream.Collectors;

public class AccountStatementMapper {

    public static AccountStatementDTO toDTO(AccountStatement accountStatement) {
        if (accountStatement == null) {
            return null;
        }

        AccountStatementDTO dto = new AccountStatementDTO();
        dto.setId(accountStatement.getId());
        dto.setAccountNumber(accountStatement.getAccount().getAccountNumber());
        dto.setStatementDate(accountStatement.getStatementDate());
        dto.setOpeningBalance(accountStatement.getOpeningBalance());
        dto.setClosingBalance(accountStatement.getClosingBalance());

        return dto;
    }

    public static List<AccountStatementDTO> toDTOList(List<AccountStatement> accountStatements) {
        return accountStatements.stream()
                .map(AccountStatementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static AccountStatement toEntity(AccountStatementDTO accountStatementDTO) {
        if (accountStatementDTO == null) {
            return null;
        }

        AccountStatement accountStatement = new AccountStatement();
        accountStatement.setStatementDate(accountStatementDTO.getStatementDate());
        accountStatement.setOpeningBalance(accountStatementDTO.getOpeningBalance());
        accountStatement.setClosingBalance(accountStatementDTO.getClosingBalance());

        return accountStatement;
    }
}
