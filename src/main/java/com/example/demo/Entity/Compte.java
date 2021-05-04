package com.example.demo.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Compte {
	@Id
	@GeneratedValue
	Long id_C;
	String nom_C;
	String prenom_C;
	String email_C;
	String password_C;
	@OneToMany (mappedBy = "id_C")
	
	List<Historique> historiques;
	@OneToOne (mappedBy = "id_C" )
	
	CreditCard creditCard;
	
	public Compte(String nom_C, String prenom_C, String email_C, String password_C) {
		super();
		this.nom_C = nom_C;
		this.prenom_C = prenom_C;
		this.email_C = email_C;
		this.password_C = password_C;
	}
	
	

	public Compte() {
		super();
	}



	public Long getId_C() {
		return id_C;
	}

	public void setId_C(Long id_C) {
		this.id_C = id_C;
	}

	public String getNom_C() {
		return nom_C;
	}

	public void setNom_C(String nom_C) {
		this.nom_C = nom_C;
	}

	public String getPrenom_C() {
		return prenom_C;
	}

	public void setPrenom_C(String prenom_C) {
		this.prenom_C = prenom_C;
	}

	public String getEmail_C() {
		return email_C;
	}

	public void setEmail_C(String email_C) {
		this.email_C = email_C;
	}

	public String getPassword_C() {
		return password_C;
	}

	public void setPassword_C(String password_C) {
		this.password_C = password_C;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}



	@Override
	public String toString() {
		return "Compte [id_C=" + id_C + ", nom_C=" + nom_C + ", prenom_C=" + prenom_C + ", email_C=" + email_C
				+ ", password_C=" + password_C + "]";
	}


	

	
	
	

}
