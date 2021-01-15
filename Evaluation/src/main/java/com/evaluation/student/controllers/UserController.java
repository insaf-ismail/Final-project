package com.evaluation.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.student.entities.AppUser;
import com.evaluation.student.entities.Compte;
import com.evaluation.student.request.AddUserRequest;
import com.evaluation.student.request.AuthRequest;
import com.evaluation.student.services.AppUserService;
import com.evaluation.student.services.CompteService;

@RestController
@RequestMapping("/Rest/Api/user")
public class UserController {
	
	@Autowired
	AppUserService appUserService;
	
	@Autowired
	CompteService compteService;
	
	@CrossOrigin(origins = "*" ) 
	@RequestMapping(method = RequestMethod.POST, value = "/signUp")
	public AppUser signUp(@RequestBody AddUserRequest addUserRequest) {
		
		AppUser appUser = new AppUser();
		appUser.setAge(addUserRequest.getAge());
		appUser.setEmail(addUserRequest.getEmail());
		appUser.setNom(addUserRequest.getNom());
		appUser.setPrenom(addUserRequest.getPrenom());
		appUser.setTel(addUserRequest.getTel());
		appUser.setRole(addUserRequest.getRole());
		
		AppUser user = appUserService.saveUser(appUser);
		
		Compte compte = new Compte();
		compte.setLogin(addUserRequest.getLogin());
		compte.setMdp(addUserRequest.getMdp());
		compte.setAppUser(user);
		Compte compteAux = compteService.addCompte(compte);
		
		return compteAux.getAppUser();
		
	}
	
	
	@CrossOrigin(origins = "*" ) 
	@RequestMapping(method = RequestMethod.POST, value = "/signIn")
	public AppUser signIn(@RequestBody AuthRequest authRequest) {
		try {
			
			Compte compte = compteService.authentification(authRequest.getLogin(), authRequest.getMdp());
			if (compte == null) {
				return null;
			}else {
				return compte.getAppUser();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	
		
	}

}
