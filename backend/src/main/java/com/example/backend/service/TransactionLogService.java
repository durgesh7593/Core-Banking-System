package com.example.backend.service;

import com.example.backend.dto.TransactionLogDTO;
import com.example.backend.entity.Transaction;
import com.example.backend.entity.TransactionLog;
import com.example.backend.mapper.TransactionLogMapper;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.repository.TransactionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionLogService {

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionLogDTO createTransactionLog(TransactionLogDTO transactionLogDTO) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transactionLogDTO.getTransactionId());
        if (transactionOptional.isPresent()) {
            TransactionLog transactionLog = TransactionLogMapper.toEntity(transactionLogDTO);
            transactionLog.setTransaction(transactionOptional.get());
            transactionLog = transactionLogRepository.save(transactionLog);
            return TransactionLogMapper.toDTO(transactionLog);
        }
        return null;
    }

    public List<TransactionLogDTO> getAllTransactionLogs() {
        List<TransactionLog> transactionLogs = transactionLogRepository.findAll();
        return TransactionLogMapper.toDTOList(transactionLogs);
    }

    public Optional<TransactionLogDTO> getTransactionLogById(Long id) {
        Optional<TransactionLog> transactionLog = transactionLogRepository.findById(id);
        return transactionLog.map(TransactionLogMapper::toDTO);
    }

    public boolean deleteTransactionLog(Long id) {
        Optional<TransactionLog> transactionLog = transactionLogRepository.findById(id);
        if (transactionLog.isPresent()) {
            transactionLogRepository.delete(transactionLog.get());
            return true;
        }
        return false;
    }

    public List<TransactionLogDTO> getLogsByTransactionId(Long transactionId) {
        List<TransactionLog> transactionLogs = transactionLogRepository.findByTransaction_Id(transactionId);
        return TransactionLogMapper.toDTOList(transactionLogs);
    }
}
