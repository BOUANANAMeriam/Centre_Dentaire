package com.fsts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
	
}

