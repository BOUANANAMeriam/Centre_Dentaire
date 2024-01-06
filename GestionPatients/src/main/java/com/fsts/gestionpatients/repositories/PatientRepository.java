package com.fsts.gestionpatients.repositories;

import com.fsts.gestionpatients.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository< Patient,Integer> {
    List<Patient> findByNomPatientContainingIgnoreCase(String nom);
}
