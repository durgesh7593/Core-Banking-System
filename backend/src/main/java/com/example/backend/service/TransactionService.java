package com.example.backend.service;

import com.example.backend.dto.TransactionDTO;
import com.example.backend.entity.Account;
import com.example.backend.entity.Transaction;
import com.example.backend.mapper.TransactionMapper;
import com.example.backend.repository.AccountRepository;
import com.example.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Optional<Account> accountOptional = accountRepository.findById(transactionDTO.getAccountNumber());
        if (accountOptional.isPresent()) {
            Transaction transaction = TransactionMapper.toEntity(transactionDTO);
            transaction.setAccount(accountOptional.get());
            transaction = transactionRepository.save(transaction);
            return TransactionMapper.toDTO(transaction);
        }
        return null;
    }

    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return TransactionMapper.toDTOList(transactions);
    }

    public Optional<TransactionDTO> getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.map(TransactionMapper::toDTO);
    }

    public boolean deleteTransaction(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            transactionRepository.delete(transaction.get());
            return true;
        }
        return false;
    }
}
