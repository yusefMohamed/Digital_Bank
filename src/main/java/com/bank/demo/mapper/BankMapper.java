package com.bank.demo.mapper;

import org.springframework.stereotype.Component;

import com.bank.demo.entity.BankEntity;
import com.bank.demo.model.BankDto;

@Component
public class BankMapper {

    public BankDto BankEntityToDto (BankEntity  bankEntity){
        BankDto bankDto = new BankDto();
        bankDto.setBankSwiftCode(bankEntity.getBankSwiftCode());
        bankDto.setBankName(bankEntity.getBankName());
        bankDto.setBankAddress(bankEntity.getBankAddress());
        bankDto.setBankCity(bankEntity.getBankCity());
        bankDto.setBankFaxNumber(bankEntity.getBankFaxNumber());
        bankDto.setBankPhoneNumber(bankEntity.getBankPhoneNumber());
        bankDto.setRequestId(bankEntity.getRequestId());
        bankDto.setBankBalance(bankEntity.getBankBalance());
        return bankDto;
    }

    public BankEntity BankDtoToEntity (BankDto bankDto){

        BankEntity bankEntity=new BankEntity();
        
        bankEntity.setBankSwiftCode(bankDto.getBankSwiftCode());
        bankEntity.setBankName(bankDto.getBankName());
        bankEntity.setBankAddress(bankDto.getBankAddress());
        bankEntity.setBankCity(bankDto.getBankCity());
        bankEntity.setBankFaxNumber(bankDto.getBankFaxNumber());
        bankEntity.setBankPhoneNumber(bankDto.getBankPhoneNumber());
        bankEntity.setRequestId(bankDto.getRequestId());
        bankEntity.setBankBalance(bankDto.getBankBalance());
        
        return bankEntity;
    }
}
