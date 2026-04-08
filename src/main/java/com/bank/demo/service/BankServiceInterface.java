package com.bank.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.demo.model.BankDto;

public interface BankServiceInterface {

    BankDto getBankBySwiftCode(String swiftCode);

    BigDecimal getBankBalanceBySwiftCode(String swiftCode);

    BankDto registerBank(BankDto bankDto);

    List<BankDto> findAllBanks();

    BankDto updateBankBySwiftCode (String bankSwiftCode, BankDto bankDto);

    void deleteBankBySwiftCode (String bankSwiftCode);

}
