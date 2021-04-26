package com.example.demo.Service;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Compte;
import com.example.demo.Repository.CompteRepository;



@RestController
@RequestMapping(value = "credit_card")
public class CreditCardService {
	@Autowired
	CompteRepository compteRepository;

	
	public boolean authentification() {
		return true;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("/Listobject")
	public List<Compte> getallwithService() {
		return compteRepository.findAll();
	}
	
}
