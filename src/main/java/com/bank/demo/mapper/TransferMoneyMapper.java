package com.bank.demo.mapper;

import org.springframework.stereotype.Component;

import com.bank.demo.entity.TransferMoneyEntity;
import com.bank.demo.model.TransferMoneyDto;

@Component
public class TransferMoneyMapper {

    public TransferMoneyEntity transferMoneyDtoToEntity (TransferMoneyDto transferMoneyDto)
    {
        TransferMoneyEntity transferMoneyEntity= new TransferMoneyEntity();

        transferMoneyEntity.setReceiverBankSwiftCode(transferMoneyDto.getReceiverBankSwiftCode());
        transferMoneyEntity.setTransferAmount(transferMoneyDto.getTransferAmount());

        return transferMoneyEntity;
    }
    
    public TransferMoneyDto transferMoneyEntityToDto (TransferMoneyEntity transferMoneyEntity)
    {
        TransferMoneyDto transferMoneyDto = new TransferMoneyDto();

        transferMoneyDto.setReceiverBankSwiftCode(transferMoneyEntity.getReceiverBankSwiftCode());
        transferMoneyDto.setTransferAmount(transferMoneyEntity.getTransferAmount());

        return transferMoneyDto;
    }


}
