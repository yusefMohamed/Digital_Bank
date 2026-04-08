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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankService implements BankServiceInterface {

    private final BankRepo bankRepo;
    private final BankMapper bankMapper;

    private BankEntity findBankBySwiftCodeOrThrow(String bankSwiftCode) {
        return bankRepo.findByBankSwiftCode(bankSwiftCode)
                .orElseThrow(() -> new CustomException(
                        "BANK_NOT_FOUND",
                        "Bank not found with swift code: " + bankSwiftCode
                ));
    }

    @Override
    public BankDto getBankBySwiftCode(String bankSwiftCode) {
        BankEntity bankEntity = findBankBySwiftCodeOrThrow(bankSwiftCode);
        return bankMapper.BankEntityToDto(bankEntity);
    }

    @Override
    public BigDecimal getBankBalanceBySwiftCode(String bankSwiftCode) {
        BankEntity bankEntity = findBankBySwiftCodeOrThrow(bankSwiftCode);
        return bankEntity.getBankBalance();
    }

    @Override
    public BankDto registerBank(BankDto bankDto) {
        if (bankRepo.existsByBankSwiftCode(bankDto.getBankSwiftCode())) {
            throw new CustomException(
                    "BANK_ALREADY_EXISTS",
                    "Bank already exists with swift code: " + bankDto.getBankSwiftCode()
            );
        }

        BankEntity bankEntity = bankMapper.BankDtoToEntity(bankDto);
        BankEntity savedBankEntity = bankRepo.save(bankEntity);

        return bankMapper.BankEntityToDto(savedBankEntity);
    }

    @Override
    public List<BankDto> findAllBanks() {
        List<BankEntity> bankEntities = bankRepo.findAll();
        return bankEntities.stream()
                .map(bankMapper::BankEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto updateBankBySwiftCode(String bankSwiftCode, BankDto bankDto) {
        BankEntity bankEntity = findBankBySwiftCodeOrThrow(bankSwiftCode);

        bankMapper.updateFromDto(bankDto, bankEntity);

        BankEntity updatedBankEntity = bankRepo.save(bankEntity);
        return bankMapper.BankEntityToDto(updatedBankEntity);
    }

    @Override
    public void deleteBankBySwiftCode(String bankSwiftCode) {
        BankEntity bankEntity = findBankBySwiftCodeOrThrow(bankSwiftCode);
        bankRepo.delete(bankEntity);
    }

}