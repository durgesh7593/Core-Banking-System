package com.example.backend.mapper;

import com.example.backend.dto.AccountDTO;
import com.example.backend.entity.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {

    public static AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }

        AccountDTO dto = new AccountDTO();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setUserId(account.getUser().getId());
        dto.setAccountType(account.getAccountType());
        dto.setBalance(account.getBalance());
        dto.setCreatedDate(account.getCreatedDate());

        return dto;
    }

    public static List<AccountDTO> toDTOList(List<Account> accounts) {
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }

        Account account = new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountType(accountDTO.getAccountType());
        account.setBalance(accountDTO.getBalance());
        account.setCreatedDate(accountDTO.getCreatedDate());

        return account;
    }
}
