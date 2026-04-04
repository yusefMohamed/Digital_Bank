package com.bank.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Entity
public class BankEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_swift_code", nullable = false )
    private String bankSwiftCode;

    @Column(name = "bank_name")
    private String bankName;


    @Column(name = "bank_address")
    private String bankAddress;
    @Column(name = "bank_city")
    private String bankCity;
    @Column(name = "bank_phone_number")
    private String bankPhoneNumber;
    @Column(name = "bank_fax_number")
    private String bankFaxNumber;
    @Column(name = "bank_balance")
    private BigDecimal bankBalance;

    private String requestId;
    
}
