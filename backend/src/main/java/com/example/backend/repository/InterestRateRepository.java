package com.example.backend.repository;

import com.example.backend.entity.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate, Long> {

    Optional<InterestRate> findByAccountType(String accountType);
}
