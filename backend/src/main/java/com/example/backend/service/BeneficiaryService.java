package com.example.backend.service;

import com.example.backend.dto.BeneficiaryDTO;
import com.example.backend.entity.Account;
import com.example.backend.entity.Beneficiary;
import com.example.backend.mapper.BeneficiaryMapper;
import com.example.backend.repository.AccountRepository;
import com.example.backend.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public BeneficiaryDTO createBeneficiary(BeneficiaryDTO beneficiaryDTO) {
        Optional<Account> accountOptional = accountRepository.findById(beneficiaryDTO.getAccountNumber());
        if (accountOptional.isPresent()) {
            Beneficiary beneficiary = BeneficiaryMapper.toEntity(beneficiaryDTO);
            beneficiary.setAccount(accountOptional.get());
            beneficiary = beneficiaryRepository.save(beneficiary);
            return BeneficiaryMapper.toDTO(beneficiary);
        }
        return null;
    }

    public List<BeneficiaryDTO> getAllBeneficiaries() {
        List<Beneficiary> beneficiaries = beneficiaryRepository.findAll();
        return BeneficiaryMapper.toDTOList(beneficiaries);
    }

    public Optional<BeneficiaryDTO> getBeneficiaryById(Long id) {
        Optional<Beneficiary> beneficiary = beneficiaryRepository.findById(id);
        return beneficiary.map(BeneficiaryMapper::toDTO);
    }

    public boolean deleteBeneficiary(Long id) {
        Optional<Beneficiary> beneficiary = beneficiaryRepository.findById(id);
        if (beneficiary.isPresent()) {
            beneficiaryRepository.delete(beneficiary.get());
            return true;
        }
        return false;
    }
}
