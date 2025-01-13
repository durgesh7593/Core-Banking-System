package com.example.backend.mapper;

import com.example.backend.dto.BeneficiaryApprovalDTO;
import com.example.backend.entity.BeneficiaryApproval;

import java.util.List;
import java.util.stream.Collectors;

public class BeneficiaryApprovalMapper {

    public static BeneficiaryApprovalDTO toDTO(BeneficiaryApproval beneficiaryApproval) {
        if (beneficiaryApproval == null) {
            return null;
        }

        BeneficiaryApprovalDTO dto = new BeneficiaryApprovalDTO();
        dto.setId(beneficiaryApproval.getId());
        dto.setBeneficiaryId(beneficiaryApproval.getBeneficiary().getId());
        dto.setAdminId(beneficiaryApproval.getAdmin().getId());
        dto.setApprovalStatus(beneficiaryApproval.getApprovalStatus());
        dto.setApprovalDate(beneficiaryApproval.getApprovalDate());

        return dto;
    }

    public static List<BeneficiaryApprovalDTO> toDTOList(List<BeneficiaryApproval> beneficiaryApprovals) {
        return beneficiaryApprovals.stream()
                .map(BeneficiaryApprovalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static BeneficiaryApproval toEntity(BeneficiaryApprovalDTO beneficiaryApprovalDTO) {
        if (beneficiaryApprovalDTO == null) {
            return null;
        }

        BeneficiaryApproval beneficiaryApproval = new BeneficiaryApproval();
        beneficiaryApproval.setApprovalStatus(beneficiaryApprovalDTO.getApprovalStatus());
        beneficiaryApproval.setApprovalDate(beneficiaryApprovalDTO.getApprovalDate());

        return beneficiaryApproval;
    }
}
