package com.fsts.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Ordonnance;


public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {
	
}

