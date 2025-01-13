package com.example.backend.service;

import com.example.backend.dto.BeneficiaryApprovalDTO;
import com.example.backend.entity.Beneficiary;
import com.example.backend.entity.BeneficiaryApproval;
import com.example.backend.entity.User;
import com.example.backend.mapper.BeneficiaryApprovalMapper;
import com.example.backend.repository.BeneficiaryApprovalRepository;
import com.example.backend.repository.BeneficiaryRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryApprovalService {

    @Autowired
    private BeneficiaryApprovalRepository beneficiaryApprovalRepository;

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private UserRepository userRepository;

    public BeneficiaryApprovalDTO createBeneficiaryApproval(BeneficiaryApprovalDTO beneficiaryApprovalDTO) {
        Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(beneficiaryApprovalDTO.getBeneficiaryId());
        Optional<User> adminOptional = userRepository.findById(beneficiaryApprovalDTO.getAdminId());

        if (beneficiaryOptional.isPresent() && adminOptional.isPresent()) {
            BeneficiaryApproval beneficiaryApproval = BeneficiaryApprovalMapper.toEntity(beneficiaryApprovalDTO);
            beneficiaryApproval.setBeneficiary(beneficiaryOptional.get());
            beneficiaryApproval.setAdmin(adminOptional.get());
            beneficiaryApproval = beneficiaryApprovalRepository.save(beneficiaryApproval);
            return BeneficiaryApprovalMapper.toDTO(beneficiaryApproval);
        }
        return null;
    }

    public List<BeneficiaryApprovalDTO> getAllBeneficiaryApprovals() {
        List<BeneficiaryApproval> beneficiaryApprovals = beneficiaryApprovalRepository.findAll();
        return BeneficiaryApprovalMapper.toDTOList(beneficiaryApprovals);
    }

    public Optional<BeneficiaryApprovalDTO> getBeneficiaryApprovalById(Long id) {
        Optional<BeneficiaryApproval> beneficiaryApproval = beneficiaryApprovalRepository.findById(id);
        return beneficiaryApproval.map(BeneficiaryApprovalMapper::toDTO);
    }

    public boolean deleteBeneficiaryApproval(Long id) {
        Optional<BeneficiaryApproval> beneficiaryApproval = beneficiaryApprovalRepository.findById(id);
        if (beneficiaryApproval.isPresent()) {
            beneficiaryApprovalRepository.delete(beneficiaryApproval.get());
            return true;
        }
        return false;
    }

    public List<BeneficiaryApprovalDTO> getApprovalsByBeneficiaryId(Long beneficiaryId) {
        List<BeneficiaryApproval> beneficiaryApprovals = beneficiaryApprovalRepository.findByBeneficiary_Id(beneficiaryId);
        return BeneficiaryApprovalMapper.toDTOList(beneficiaryApprovals);
    }
}
