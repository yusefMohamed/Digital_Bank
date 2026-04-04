package com.bank.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "requestmoney")
public class RequestMoneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    private Date requestDate;
    private Time requestTime;
    private String requestStatus;
    private BigDecimal requestAmount;

    private String senderBankName;
    private String senderBankSwiftCode;

}
