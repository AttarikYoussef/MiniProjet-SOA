package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.CreditCard;
import com.example.demo.Entity.Historique;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.CreditCardRepository;
import com.example.demo.Repository.HistoriqueRepository;

@SpringBootTest
class MiniProjetSoaApplicationTests {

	@Autowired
	CompteRepository compte;
	@Autowired
	CreditCardRepository card;
	@Autowired
	HistoriqueRepository historique;
	@Test
	void contextLoads() {
		card.save(new CreditCard(123456789L,compte.findCompteEmail("attarikyoussef8@gmail.com")));
		//System.out.println(compte.findCompteEmail("attarikyoussef8@gmail.com"));
		//System.out.println(card.findById(123456789L));
		
		historique.save(new Historique(1L, compte.findCompteEmail("attarikyoussef8@gmail.com"), "Consultation"));
		
	}

}
