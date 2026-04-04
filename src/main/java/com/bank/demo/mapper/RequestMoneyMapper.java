package com.bank.demo.mapper;

import org.springframework.stereotype.Component;

import com.bank.demo.entity.RequestMoneyEntity;
import com.bank.demo.model.RequestMoneyDto;

@Component
public class RequestMoneyMapper {
    
    public RequestMoneyEntity requestMoneyDtoToEntity (RequestMoneyDto requestMoneyDto){

        RequestMoneyEntity requestMoneyEntity = new RequestMoneyEntity();

        requestMoneyEntity.setRequestAmount(requestMoneyDto.getRequestAmount());
        requestMoneyEntity.setSenderBankName(requestMoneyDto.getSenderBankName());
        requestMoneyEntity.setSenderBankSwiftCode(requestMoneyDto.getSenderBankSwiftCode());

        return requestMoneyEntity;
    }
    
    public RequestMoneyDto requestMoneyEntityToDto (RequestMoneyEntity requestMoneyEntity){

        RequestMoneyDto requestMoneyDto = new RequestMoneyDto();

        requestMoneyDto.setRequestAmount(requestMoneyEntity.getRequestAmount());
        requestMoneyDto.setSenderBankName(requestMoneyEntity.getSenderBankName());
        requestMoneyDto.setSenderBankSwiftCode(requestMoneyEntity.getSenderBankSwiftCode());
        return requestMoneyDto;
    }


}
