package com.evaluation.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluation.student.entities.Livre;


@Repository
public interface LivreRepository extends JpaRepository<Livre, Long>{
	


}
