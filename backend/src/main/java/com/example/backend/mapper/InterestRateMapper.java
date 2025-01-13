package com.example.backend.mapper;

import com.example.backend.dto.InterestRateDTO;
import com.example.backend.entity.InterestRate;

import java.util.List;
import java.util.stream.Collectors;

public class InterestRateMapper {

    public static InterestRateDTO toDTO(InterestRate interestRate) {
        if (interestRate == null) {
            return null;
        }

        InterestRateDTO dto = new InterestRateDTO();
        dto.setId(interestRate.getId());
        dto.setAccountType(interestRate.getAccountType());
        dto.setInterestRate(interestRate.getInterestRate());

        return dto;
    }

    public static List<InterestRateDTO> toDTOList(List<InterestRate> interestRates) {
        return interestRates.stream()
                .map(InterestRateMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static InterestRate toEntity(InterestRateDTO interestRateDTO) {
        if (interestRateDTO == null) {
            return null;
        }

        InterestRate interestRate = new InterestRate();
        interestRate.setAccountType(interestRateDTO.getAccountType());
        interestRate.setInterestRate(interestRateDTO.getInterestRate());

        return interestRate;
    }
}
