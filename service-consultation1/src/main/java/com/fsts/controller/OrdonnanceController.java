package com.fsts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fsts.Repository.OrdonnanceRepository;
import com.fsts.entities.Facture;
import com.fsts.entities.Ordonnance;
@RestController
@RequestMapping("/Ordonnances")
public class OrdonnanceController {

    @Autowired
    OrdonnanceRepository OrdonnanceRepository;
    @PostMapping
    public Ordonnance createOrdonnance(@RequestBody Ordonnance Ordonnance) {
        return OrdonnanceRepository.save(Ordonnance);
    }
    @GetMapping("/{id}")
    public Ordonnance getOrdonnanceById(@PathVariable Integer id) {
    return OrdonnanceRepository.findById(id).get();
    }
   
    @GetMapping
    public List<Ordonnance> getAllOrdonnances() {
        return OrdonnanceRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public boolean supprimer(@PathVariable Integer id) {
        try {
            OrdonnanceRepository.deleteById(id);
            return true; // Suppression réussie
        } catch (Exception e) {
            return false; // Échec de la suppression
        }
    }

    @PutMapping("/{id}")
    public Ordonnance save (@PathVariable Integer id ,@RequestBody Ordonnance o){
		o.setId(id);
		return OrdonnanceRepository.save(o);
	}
		 
 
    }

