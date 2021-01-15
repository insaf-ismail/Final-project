package com.evaluation.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.student.entities.Compte;
import com.evaluation.student.repositories.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	CompteRepository compteRepository;
	
	public Compte authentification(String login, String mdp) {
		return compteRepository.authentification(login, mdp);
	}
	
	public Compte addCompte(Compte compte) {
		return compteRepository.save(compte);
	}

}
