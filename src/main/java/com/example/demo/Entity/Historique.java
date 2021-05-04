package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Historique {
	@Id
	@GeneratedValue
	Long id_Historique;
	@ManyToOne@JoinColumn
	@JsonIgnore
	Compte id_C;
	Date date_Action;
	String service_Consomme;
	
	public Historique(Compte id_C, Date date_Action, String service_Consomme) {
		super();
		this.id_C = id_C;
		this.date_Action = date_Action;
		this.service_Consomme = service_Consomme;
	}
	
	

	
	public Historique(Long id_Historique, Compte id_C, String service_Consomme) {
		super();
		this.id_Historique = id_Historique;
		this.id_C = id_C;
		this.service_Consomme = service_Consomme;
	}




	public Historique() {
		super();
	}


	public Long getId_Historique() {
		return id_Historique;
	}

	public void setId_Historique(Long id_Historique) {
		this.id_Historique = id_Historique;
	}

	public Compte getId_C() {
		return id_C;
	}

	public void setId_C(Compte id_C) {
		this.id_C = id_C;
	}

	public Date getDate_Action() {
		return date_Action;
	}

	public void setDate_Action(Date date_Action) {
		this.date_Action = date_Action;
	}

	public String getService_Consomme() {
		return service_Consomme;
	}

	public void setService_Consomme(String service_Consomme) {
		this.service_Consomme = service_Consomme;
	}

	@Override
	public String toString() {
		return "Historique [id_Historique=" + id_Historique + ", id_C=" + id_C + ", date_Action=" + date_Action
				+ ", service_Consomme=" + service_Consomme + "]";
	}
	
	

}
