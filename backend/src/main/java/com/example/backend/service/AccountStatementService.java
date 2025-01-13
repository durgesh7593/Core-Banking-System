package com.example.backend.service;

import com.example.backend.dto.AccountStatementDTO;
import com.example.backend.entity.Account;
import com.example.backend.entity.AccountStatement;
import com.example.backend.mapper.AccountStatementMapper;
import com.example.backend.repository.AccountRepository;
import com.example.backend.repository.AccountStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountStatementService {

    @Autowired
    private AccountStatementRepository accountStatementRepository;

    @Autowired
    private AccountRepository accountRepository;

    public AccountStatementDTO createAccountStatement(AccountStatementDTO accountStatementDTO) {
        Optional<Account> accountOptional = accountRepository.findById(accountStatementDTO.getAccountNumber());
        if (accountOptional.isPresent()) {
            AccountStatement accountStatement = AccountStatementMapper.toEntity(accountStatementDTO);
            accountStatement.setAccount(accountOptional.get());
            accountStatement = accountStatementRepository.save(accountStatement);
            return AccountStatementMapper.toDTO(accountStatement);
        }
        return null;
    }

    public List<AccountStatementDTO> getAllAccountStatements() {
        List<AccountStatement> accountStatements = accountStatementRepository.findAll();
        return AccountStatementMapper.toDTOList(accountStatements);
    }

    public Optional<AccountStatementDTO> getAccountStatementById(Long id) {
        Optional<AccountStatement> accountStatement = accountStatementRepository.findById(id);
        return accountStatement.map(AccountStatementMapper::toDTO);
    }

    public boolean deleteAccountStatement(Long id) {
        Optional<AccountStatement> accountStatement = accountStatementRepository.findById(id);
        if (accountStatement.isPresent()) {
            accountStatementRepository.delete(accountStatement.get());
            return true;
        }
        return false;
    }

    public List<AccountStatementDTO> getStatementsByAccountNumber(String accountNumber) {
        List<AccountStatement> accountStatements = accountStatementRepository.findByAccount_AccountNumber(accountNumber);
        return AccountStatementMapper.toDTOList(accountStatements);
    }
}
