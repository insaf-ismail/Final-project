package com.evaluation.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "livre")
public class Livre {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="livreSeq") 
    @SequenceGenerator(name="livreSeq",sequenceName="LIVRE_ID",allocationSize =1) 
	@Column(name="id")
	private long id;
	
	private String nom;
	private String auteur;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=true, updatable=true)
	@JsonBackReference
	private AppUser appUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	
	

}
