package com.fsts.controller;

import java.util.List;

import com.fsts.Repository.FactureRepository;
import com.fsts.entities.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    FactureRepository factureRepository;
    @PostMapping("/creatFacture")
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }
    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Integer id) {
    return factureRepository.findById(id).get();
    }
    @GetMapping
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public boolean supprimer(@PathVariable Integer id) {
        try {
            factureRepository.deleteById(id);
            return true; // Suppression réussie
        } catch (Exception e) {
            return false; // Échec de la suppression
        }
    }

    @PutMapping("/{id}")
    public Facture save (@PathVariable Integer id ,@RequestBody Facture f){
		f.setId(id);
		return factureRepository.save(f);
	}
		 
 
    }

