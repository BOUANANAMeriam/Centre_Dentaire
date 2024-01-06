package com.fsts.controller;

import java.util.List;

import com.fsts.Repository.ConsultationRepository;
import com.fsts.entities.Consultation;
import com.fsts.services.OpenFeignTraitement;
import com.fsts.services.Traitement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController

public class ConsultationController {

    @Autowired
    ConsultationRepository ConsultationRepository;
    
    @Autowired
    OpenFeignTraitement openTraitement;
    
    @PostMapping("/createConsultation")
    public Consultation createConsultation(@RequestBody Consultation Consultation) {
        return ConsultationRepository.save(Consultation);
    }
   
    @GetMapping("/Consultations")
    public List<Consultation> getAllConsultations() {
        return ConsultationRepository.findAll();
    }
    
 
    @GetMapping("/ConsultationTrait/{id}")
    public Consultation getConsultationById(@PathVariable Integer id) {
        Consultation consultation = ConsultationRepository.findById(id).orElse(null);
        

        if (consultation != null) {
        	System.out.println("Okkokkkk");
            Traitement traitements = openTraitement.getTraitementById(consultation.getIdTraitement());
            consultation.setTraitementModel(traitements);
          
        }

        return consultation;
    }

    
    
    @DeleteMapping("/deleteConsultation/{id}")
    public boolean supprimer(@PathVariable Integer id) {
        try {
            ConsultationRepository.deleteById(id);
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }

    @PutMapping("/ModifierCons/{id}")
    public Consultation save (@PathVariable Integer id ,@RequestBody Consultation c){
		c.setId(id);
		return ConsultationRepository.save(c);
	}
		 
 
    }

