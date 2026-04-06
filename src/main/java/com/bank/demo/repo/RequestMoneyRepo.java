package com.bank.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.RequestMoneyEntity;

@Repository
public interface RequestMoneyRepo extends JpaRepository<RequestMoneyEntity,Integer>{
    
}
