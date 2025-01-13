package com.example.backend.repository;

import com.example.backend.entity.TransactionApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionApprovalRepository extends JpaRepository<TransactionApproval, Long> {

    List<TransactionApproval> findByTransaction_Id(Long transactionId);
}
