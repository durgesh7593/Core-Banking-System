package com.example.backend.repository;

import com.example.backend.entity.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long> {

    List<AccountStatement> findByAccount_AccountNumber(String accountNumber);
}
