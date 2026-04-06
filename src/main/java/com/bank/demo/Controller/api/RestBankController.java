package com.bank.demo.Controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.exception.GeneralResponse;
import com.bank.demo.model.BankDto;
import com.bank.demo.service.BankService;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor

public class RestBankController {

    private final BankService bankService;

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse<BankDto>> registerBank(@RequestBody BankDto bankDto) {

        bankService.registerBank(bankDto);
        GeneralResponse<BankDto> response = new GeneralResponse<BankDto>(
                bankDto,
                "Bank Registered Succesfully",
                HttpStatus.CREATED.value());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/balance/{swiftCode}")
    public ResponseEntity<GeneralResponse<BigDecimal>> getBalanceBySwiftCode(@PathVariable String swiftCode) {

        BigDecimal bankBalance = bankService.getBankBalanceBySwiftCode(swiftCode);
        GeneralResponse<BigDecimal> response = new GeneralResponse<BigDecimal>(
                bankBalance,
                "Bank balance get successfully",
                HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<GeneralResponse<List<BankDto>>> getAllBanks() {

        List <BankDto> bankDtos = bankService.findAllBanks();
        GeneralResponse<List<BankDto>> response = new GeneralResponse<>(
            bankDtos,
            "All Banks Fetched Succesfully",
            HttpStatus.OK.value());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{swiftCode}")
    public ResponseEntity<GeneralResponse<BankDto>> getBankeBySwiftCode(@PathVariable String swiftCode) {

        BankDto bankDto = bankService.getBankBySwiftCode(swiftCode);
        GeneralResponse<BankDto> response = new GeneralResponse<BankDto>(
                bankDto,
                "Bank fetched successfully",
                HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

}
