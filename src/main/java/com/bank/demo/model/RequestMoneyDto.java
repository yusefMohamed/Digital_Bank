package com.bank.demo.model;
import lombok.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestMoneyDto {

    private String senderBankSwiftCode;
    private String senderBankName;
    private BigDecimal requestAmount;



}
