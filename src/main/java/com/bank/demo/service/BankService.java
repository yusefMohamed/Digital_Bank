package com.bank.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bank.demo.entity.BankEntity;
import com.bank.demo.exception.CustomException;
import com.bank.demo.mapper.BankMapper;
import com.bank.demo.model.BankDto;
import com.bank.demo.repo.BankRepo;
import lombok.*;

@Service
@RequiredArgsConstructor
public class BankService implements BankServiceInterface {

    private final BankRepo bankRepo;
    private final BankMapper bankMapper;

    @Override
    public BankDto getBankBySwiftCode(String swiftCode) {

        BankEntity bankEntity = bankRepo.findByBankSwiftCode(swiftCode)
                .orElseThrow(() -> new CustomException("404", "Bank is not found"));

        return bankMapper.BankEntityToDto(bankEntity);

    }

    @Override
    public BigDecimal getBankBalanceBySwiftCode(String swiftCode) {

        BankEntity bankEntity = bankRepo.findByBankSwiftCode(swiftCode)
                .orElseThrow(() -> new CustomException("BANK_NOT_FOUND", "Bank is not found with swiftcode: "+swiftCode));

        return bankMapper.BankEntityToDto(bankEntity).getBankBalance();

    }

    @Override
    public BankEntity registerBank(BankDto bankDto) {
        
        boolean bankExists = bankRepo.existsByBankSwiftCode(bankDto.getBankSwiftCode());
        if (bankExists) {
        throw new CustomException(
                "SWIFT_CODE_ALREADY_EXISTS",
                "Another bank already exists with swift code: " + bankDto.getBankSwiftCode()
        );
    }
        BankEntity bankEntity = bankMapper.BankDtoToEntity(bankDto);
        BankEntity savedBankEntity= bankRepo.save(bankEntity);
        return savedBankEntity;
    }

    @Override
    public List<BankDto> findAllBanks() {
        List <BankEntity> bankEntities= bankRepo.findAll();
        return bankEntities.stream()
        .map( entity -> bankMapper.BankEntityToDto(entity))
        .collect(Collectors.toList());
    }

}
