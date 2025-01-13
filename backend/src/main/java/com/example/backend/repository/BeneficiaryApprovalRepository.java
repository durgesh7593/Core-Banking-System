package com.example.backend.repository;

import com.example.backend.entity.BeneficiaryApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaryApprovalRepository extends JpaRepository<BeneficiaryApproval, Long> {

    List<BeneficiaryApproval> findByBeneficiary_Id(Long beneficiaryId);
}
