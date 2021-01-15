package com.evaluation.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evaluation.student.entities.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>{
	
	
	@Query("SELECT c FROM Media c  where c.idLivre = :idLivre")
	Media getByIdLivre(@Param("idLivre") Long idLivre);

}
