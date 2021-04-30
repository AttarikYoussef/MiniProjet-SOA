package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {
	@Query("SELECT c FROM Compte c WHERE c.email_C = :em and c.password_C = :pass")
	public Compte findCompte(@Param("em")String email,@Param("pass")String pass);
}
