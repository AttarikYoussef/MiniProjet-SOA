package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Query("select c from CreditCard c where c.nCard = :id")
	public CreditCard getCardID(@Param("id") Long ID);
}
