package com.evaluation.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.student.entities.Livre;
import com.evaluation.student.repositories.LivreRepository;

@Service
public class LivreService {

	@Autowired
	LivreRepository livreRepository;
	
	
	public Livre addLivre(Livre livre) {
		return livreRepository.save(livre);
	}
	
	public List<Livre> getAllLivre(){
		return livreRepository.findAll();
	}
	
	public void deleteLivre(Long id) {
		livreRepository.deleteById(id);
	}
}
