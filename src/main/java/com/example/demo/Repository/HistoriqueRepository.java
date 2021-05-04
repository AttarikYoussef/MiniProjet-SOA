package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Historique;

public interface HistoriqueRepository extends JpaRepository<Historique, Long> {

}
