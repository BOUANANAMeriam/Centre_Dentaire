package org.sid.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.sid.entities.Dent;
import org.sid.entities.Traitement;
import org.sid.entities.User;
import org.sid.repositories.DentRepository;
import org.sid.repositories.TraitementRepository;
import org.sid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class Controller {
	@Autowired
	private TraitementRepository traitementRep;
	@Autowired
	private DentRepository dentRep;
	@Autowired
	private UserRepository userRep;
	    
	   
	    @GetMapping("/Allusers")
	    public List<User> getUsers(){
	    	return userRep.findAll();
	    }
	    
	    @PostMapping("/seConnecter/{username}/{motPasse}")
	    public String seConnecter(@PathVariable String username, @PathVariable String motPasse) {
	        System.out.println("Yousseffffffffffffffff________________________________");
	        User user = userRep.findByusername(username);
	        System.out.println("kimo_______________________________________________");

	        if (user != null && motPasse.equals(user.getMotPasse())) {
	            return "Authentication successful!";
	        } else {
	            return "Invalid login or password.";
	        }
	    }
	    @PostMapping("/CreateAccount")
	    public String CreateCompte(@RequestBody User user) {
	    	if(userRep.findByusername(user.getUsername())!=null) {
	    		return "Utilsateur deja existe";
	    	}
			 userRep.save(user);
			 return "Compte Cree avec succes";
	    	
	    }

	
	@GetMapping("Hello")
	public String Kamal() {
		return "Kamal";
	}
	 @PostMapping("/createTraitement")
	  public Traitement save(@RequestBody Traitement traitement) {
		
	      return traitementRep.save(traitement);
	  }
	 @PostMapping("/createDent")
	  public Dent save(@RequestBody Dent dent) {
		
	      return dentRep.save(dent);
	  }
	 @GetMapping("/traitements")
	    public List<Traitement> getAllTraitements() {
	        return traitementRep.findAll();
	    }
	 @GetMapping("/dents")
	    public List<Dent> getAllDents() {
	        return dentRep.findAll();
	    }
	
	 @PutMapping("/ajouterDentAuTraitement/{traitementId}/{dentId}")
	 public Traitement ajouterDentAuTraitement(@PathVariable Long traitementId, @PathVariable Long dentId) {
	     Traitement traitement = traitementRep.findById(traitementId)
	             .orElseThrow(() -> new EntityNotFoundException("Traitement not found with ID: " + traitementId));

	     Dent dent = dentRep.findById(dentId)
	             .orElseThrow(() -> new EntityNotFoundException("Dent not found with ID: " + dentId));
	 
	     traitement.getDents().add(dent);
	     dentRep.save(dent);
	     traitementRep.save(traitement);
	     return traitement;
	 }


	    @GetMapping("/dentsDuTraitement/{traitementId}")
	    public Set<Dent> getDentsDuTraitement(@PathVariable Long traitementId) {
	     
	        return traitementRep.findDentsByTraitementId(traitementId);
	    }
	    @GetMapping("traitement/{id}")
		public Traitement getTraitement(@PathVariable Long id){
			return traitementRep.findById(id).get();
		}
	    @GetMapping("dent/{id}")
	  		public Dent getDent(@PathVariable Long id){
	  			return dentRep.findById(id).get();
	  		}
	    @GetMapping("/traitementsDuDent/{dentId}")
	    public Set<Traitement> getTraitementDuDents(@PathVariable Long dentId) {
	     
	        return dentRep.findTraitemtsByDentId(dentId);
	    }
	    

}

