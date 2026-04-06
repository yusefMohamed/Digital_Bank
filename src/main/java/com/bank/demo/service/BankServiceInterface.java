package com.bank.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.demo.entity.BankEntity;
import com.bank.demo.model.BankDto;

public interface BankServiceInterface {

    BankDto getBankBySwiftCode(String swiftCode);

    BigDecimal getBankBalanceBySwiftCode(String swiftCode);

    BankEntity registerBank(BankDto bankDto);

    List<BankDto> findAllBanks();

}
