package com.example.backend.repository;

import com.example.backend.entity.AccountApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountApprovalRepository extends JpaRepository<AccountApproval, Long> {

    List<AccountApproval> findByAccount_AccountNumber(String accountNumber);
}
