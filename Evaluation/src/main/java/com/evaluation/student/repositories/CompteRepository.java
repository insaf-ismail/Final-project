package com.evaluation.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluation.student.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	
	@Query("SELECT c FROM Compte c  where c.login = :login and c.mdp = :mdp")
	Compte authentification(@Param("login") String login,@Param("mdp") String mdp);

}
