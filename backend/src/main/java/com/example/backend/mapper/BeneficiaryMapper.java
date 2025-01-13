package com.example.backend.mapper;

import com.example.backend.dto.BeneficiaryDTO;
import com.example.backend.entity.Beneficiary;

import java.util.List;
import java.util.stream.Collectors;

public class BeneficiaryMapper {

    public static BeneficiaryDTO toDTO(Beneficiary beneficiary) {
        if (beneficiary == null) {
            return null;
        }

        BeneficiaryDTO dto = new BeneficiaryDTO();
        dto.setId(beneficiary.getId());
        dto.setAccountNumber(beneficiary.getAccount().getAccountNumber());
        dto.setBeneficiaryName(beneficiary.getBeneficiaryName());
        dto.setBeneficiaryAccountNumber(beneficiary.getBeneficiaryAccountNumber());

        return dto;
    }

    public static List<BeneficiaryDTO> toDTOList(List<Beneficiary> beneficiaries) {
        return beneficiaries.stream()
                .map(BeneficiaryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Beneficiary toEntity(BeneficiaryDTO beneficiaryDTO) {
        if (beneficiaryDTO == null) {
            return null;
        }

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
        beneficiary.setBeneficiaryAccountNumber(beneficiaryDTO.getBeneficiaryAccountNumber());

        return beneficiary;
    }
}
