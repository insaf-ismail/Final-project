package com.evaluation.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluation.student.entities.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

}
