package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CreditCard {
	@Id
	Long nCard;
	@OneToOne@JoinColumn
	@JsonIgnore
	Compte id_C;
	Date dateExpiration;
	public CreditCard(Long nCard, Compte id_C, Date dateExpiration) {
		super();
		this.nCard = nCard;
		this.id_C = id_C;
		this.dateExpiration = dateExpiration;
	}
	
	
	
	public CreditCard(Long nCard, Compte id_C) {
		super();
		this.nCard = nCard;
		this.id_C = id_C;
	}



	public CreditCard() {
		super();
	}

	public Long getnCard() {
		return nCard;
	}
	public void setnCard(Long nCard) {
		this.nCard = nCard;
	}
	public Compte getId_C() {
		return id_C;
	}
	public void setId_C(Compte id_C) {
		this.id_C = id_C;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@Override
	public String toString() {
		return "CreditCard [nCard=" + nCard + ", id_C=" + id_C + ", dateExpiration=" + dateExpiration + "]";
	}
	
	

}
