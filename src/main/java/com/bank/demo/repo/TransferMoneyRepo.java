package com.bank.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.TransferMoneyEntity;

@Repository
public interface TransferMoneyRepo extends JpaRepository<TransferMoneyEntity,Integer> {
    
}
