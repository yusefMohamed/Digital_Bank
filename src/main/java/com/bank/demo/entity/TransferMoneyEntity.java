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
@Table(name = "transfermoney")
public class TransferMoneyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_id")
    private int transferId;
    @Column(name = "transfer_date")
    private Date transferDate;
    @Column(name = "transfer_time")
    private Time transferTime;
    @Column(name = "transfer_status")
    private String transferStatus;
    @Column(name = "transfer_amount")
    private BigDecimal transferAmount;
    @Column(name = "receiver_bank_id")
    private int receiverBankId;
    @Column(name = "receiver_bank_name")
    private String receiverBankName;
    @Column(name = "receiver_bank_swift_code")
    private String receiverBankSwiftCode;

}
