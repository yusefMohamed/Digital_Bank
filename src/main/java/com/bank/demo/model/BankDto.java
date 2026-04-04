package com.bank.demo.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BankDto {
    private String bankName;
    private String bankSwiftCode;
    private String bankAddress;
    private String bankCity;
    private String bankPhoneNumber;
    private String bankFaxNumber;
    private String requestId;
    private BigDecimal bankBalance;

}
