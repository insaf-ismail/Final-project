package com.evaluation.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
public class Compte {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="compteSeq") 
    @SequenceGenerator(name="compteSeq",sequenceName="COMPTE_ID",allocationSize =1) 
	@Column(name="id")
	private long id;
	
	private String login;
	private String mdp;
	
	@OneToOne
	private AppUser appUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Compte() {
		super();
	}
	
	
	

}
