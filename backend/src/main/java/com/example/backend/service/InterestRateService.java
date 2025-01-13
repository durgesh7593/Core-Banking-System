package com.example.backend.service;

import com.example.backend.dto.InterestRateDTO;
import com.example.backend.entity.InterestRate;
import com.example.backend.mapper.InterestRateMapper;
import com.example.backend.repository.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestRateService {

    @Autowired
    private InterestRateRepository interestRateRepository;

    public InterestRateDTO createInterestRate(InterestRateDTO interestRateDTO) {
        InterestRate interestRate = InterestRateMapper.toEntity(interestRateDTO);
        interestRate = interestRateRepository.save(interestRate);
        return InterestRateMapper.toDTO(interestRate);
    }

    public List<InterestRateDTO> getAllInterestRates() {
        List<InterestRate> interestRates = interestRateRepository.findAll();
        return InterestRateMapper.toDTOList(interestRates);
    }

    public Optional<InterestRateDTO> getInterestRateById(Long id) {
        Optional<InterestRate> interestRate = interestRateRepository.findById(id);
        return interestRate.map(InterestRateMapper::toDTO);
    }

    public boolean deleteInterestRate(Long id) {
        Optional<InterestRate> interestRate = interestRateRepository.findById(id);
        if (interestRate.isPresent()) {
            interestRateRepository.delete(interestRate.get());
            return true;
        }
        return false;
    }

    public Optional<InterestRateDTO> getInterestRateByAccountType(String accountType) {
        Optional<InterestRate> interestRate = interestRateRepository.findByAccountType(accountType);
        return interestRate.map(InterestRateMapper::toDTO);
    }
}
