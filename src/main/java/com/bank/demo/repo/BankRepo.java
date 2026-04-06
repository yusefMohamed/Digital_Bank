package com.bank.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.BankEntity;

@Repository
public interface BankRepo extends JpaRepository<BankEntity,Integer> {
    
    public Optional <BankEntity> findByBankSwiftCode(String bankSwiftCode);
    boolean existsByBankSwiftCode(String bankSwiftCode);
}
