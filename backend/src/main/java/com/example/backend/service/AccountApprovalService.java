package com.example.backend.service;

import com.example.backend.dto.AccountApprovalDTO;
import com.example.backend.entity.Account;
import com.example.backend.entity.AccountApproval;
import com.example.backend.entity.User;
import com.example.backend.mapper.AccountApprovalMapper;
import com.example.backend.repository.AccountApprovalRepository;
import com.example.backend.repository.AccountRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountApprovalService {

    @Autowired
    private AccountApprovalRepository accountApprovalRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public AccountApprovalDTO createAccountApproval(AccountApprovalDTO accountApprovalDTO) {
        Optional<Account> accountOptional = accountRepository.findById(accountApprovalDTO.getAccountNumber());
        Optional<User> adminOptional = userRepository.findById(accountApprovalDTO.getAdminId());

        if (accountOptional.isPresent() && adminOptional.isPresent()) {
            AccountApproval accountApproval = AccountApprovalMapper.toEntity(accountApprovalDTO);
            accountApproval.setAccount(accountOptional.get());
            accountApproval.setAdmin(adminOptional.get());
            accountApproval = accountApprovalRepository.save(accountApproval);
            return AccountApprovalMapper.toDTO(accountApproval);
        }
        return null;
    }

    public List<AccountApprovalDTO> getAllAccountApprovals() {
        List<AccountApproval> accountApprovals = accountApprovalRepository.findAll();
        return AccountApprovalMapper.toDTOList(accountApprovals);
    }

    public Optional<AccountApprovalDTO> getAccountApprovalById(Long id) {
        Optional<AccountApproval> accountApproval = accountApprovalRepository.findById(id);
        return accountApproval.map(AccountApprovalMapper::toDTO);
    }

    public boolean deleteAccountApproval(Long id) {
        Optional<AccountApproval> accountApproval = accountApprovalRepository.findById(id);
        if (accountApproval.isPresent()) {
            accountApprovalRepository.delete(accountApproval.get());
            return true;
        }
        return false;
    }

    public List<AccountApprovalDTO> getApprovalsByAccountNumber(String accountNumber) {
        List<AccountApproval> accountApprovals = accountApprovalRepository.findByAccount_AccountNumber(accountNumber);
        return AccountApprovalMapper.toDTOList(accountApprovals);
    }
}
