package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Compte;
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
		//compte.save(new Compte("Attarik", "Youssef", "attarikyoussef8@gmail.com", "199809"));
		card.save(new CreditCard(123456789L,compte.findCompteEmail("attarikyoussef8@gmail.com"),"12/29"));
		//System.out.println(compte.findCompteEmail("attarikyoussef8@gmail.com"));
		//System.out.println(card.findById(123456789L));
		//historique.save(new Historique(1L, compte.findCompteEmail("attarikyoussef8@gmail.com"), "Consultation"));
		//System.out.println(card.getCardID(123456789L));
		
		//System.out.println(ValidateCard("5321962073180129"));
	}
	public boolean ValidateCard (String ccNumber) {
		int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (alternate)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                alternate = !alternate;
        }
        return (sum % 10 == 0);
	
	}
	

}
