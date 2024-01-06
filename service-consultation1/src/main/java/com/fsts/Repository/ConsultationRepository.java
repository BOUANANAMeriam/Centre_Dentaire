package com.fsts.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
	
}
