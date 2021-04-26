package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
