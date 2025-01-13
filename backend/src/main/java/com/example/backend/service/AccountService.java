package com.example.backend.service;

import com.example.backend.dto.AccountDTO;
import com.example.backend.entity.Account;
import com.example.backend.entity.User;
import com.example.backend.mapper.AccountMapper;
import com.example.backend.repository.AccountRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Optional<User> userOptional = userRepository.findById(accountDTO.getUserId());
        if (userOptional.isPresent()) {
            Account account = AccountMapper.toEntity(accountDTO);
            account.setUser(userOptional.get());
            account = accountRepository.save(account);
            return AccountMapper.toDTO(account);
        }
        return null;
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return AccountMapper.toDTOList(accounts);
    }

    public Optional<AccountDTO> getAccountByNumber(String accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        return account.map(AccountMapper::toDTO);
    }

    public boolean deleteAccount(String accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
            return true;
        }
        return false;
    }
}
