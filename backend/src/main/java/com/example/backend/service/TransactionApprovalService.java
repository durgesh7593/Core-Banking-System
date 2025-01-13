package com.example.backend.service;

import com.example.backend.dto.TransactionApprovalDTO;
import com.example.backend.entity.Transaction;
import com.example.backend.entity.TransactionApproval;
import com.example.backend.entity.User;
import com.example.backend.mapper.TransactionApprovalMapper;
import com.example.backend.repository.TransactionApprovalRepository;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionApprovalService {

    @Autowired
    private TransactionApprovalRepository transactionApprovalRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public TransactionApprovalDTO createTransactionApproval(TransactionApprovalDTO transactionApprovalDTO) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transactionApprovalDTO.getTransactionId());
        Optional<User> adminOptional = userRepository.findById(transactionApprovalDTO.getAdminId());

        if (transactionOptional.isPresent() && adminOptional.isPresent()) {
            TransactionApproval transactionApproval = TransactionApprovalMapper.toEntity(transactionApprovalDTO);
            transactionApproval.setTransaction(transactionOptional.get());
            transactionApproval.setAdmin(adminOptional.get());
            transactionApproval = transactionApprovalRepository.save(transactionApproval);
            return TransactionApprovalMapper.toDTO(transactionApproval);
        }
        return null;
    }

    public List<TransactionApprovalDTO> getAllTransactionApprovals() {
        List<TransactionApproval> transactionApprovals = transactionApprovalRepository.findAll();
        return TransactionApprovalMapper.toDTOList(transactionApprovals);
    }

    public Optional<TransactionApprovalDTO> getTransactionApprovalById(Long id) {
        Optional<TransactionApproval> transactionApproval = transactionApprovalRepository.findById(id);
        return transactionApproval.map(TransactionApprovalMapper::toDTO);
    }

    public boolean deleteTransactionApproval(Long id) {
        Optional<TransactionApproval> transactionApproval = transactionApprovalRepository.findById(id);
        if (transactionApproval.isPresent()) {
            transactionApprovalRepository.delete(transactionApproval.get());
            return true;
        }
        return false;
    }

    public List<TransactionApprovalDTO> getApprovalsByTransactionId(Long transactionId) {
        List<TransactionApproval> transactionApprovals = transactionApprovalRepository.findByTransaction_Id(transactionId);
        return TransactionApprovalMapper.toDTOList(transactionApprovals);
    }
}
