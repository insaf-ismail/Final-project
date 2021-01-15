package com.evaluation.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.student.entities.AppUser;
import com.evaluation.student.repositories.AppUserRepository;

@Service
public class AppUserService {

	@Autowired
	AppUserRepository appUserRepository;
	
	public AppUser saveUser(AppUser user) {
		return appUserRepository.save(user);
	}
	
	public AppUser getUserById(long id) {
		return appUserRepository.getOne(id);
	}
}
