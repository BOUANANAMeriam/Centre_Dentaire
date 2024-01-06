package com.fsts.gestionpatients.controllers;
import com.fsts.gestionpatients.entities.Patient;
import com.fsts.gestionpatients.repositories.PatientRepository;
import com.fsts.gestionpatients.services.FeignRendezVous;
import com.fsts.gestionpatients.services.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    FeignRendezVous feignRendezVous;

    //afficher tous les patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    //ajout nouveau Patient
    @PostMapping("addNewPatient")
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
    //afficher patient par id
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        Patient patient = patientRepository.findById(id).get();
        RendezVous rendezVous = feignRendezVous.getRdvById(patient.getIdPatient());
        patient.setRendezVous(rendezVous);
        return patient;
    }

    //supprimer patient par id
    @DeleteMapping("/delete/{id}")
    public  void deletePatientById(@PathVariable Integer id) {
        patientRepository.deleteById(id);
    }
    
    //modifier pateint par id
    @PutMapping ("edit/{id}")
    public ResponseEntity<String> editPatientById(@PathVariable Integer id, @RequestBody Patient updatedPatients) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);

        if (existingPatient != null) {

            existingPatient.setNomPatient(updatedPatients.getNomPatient());
            existingPatient.setPrenomPatient(updatedPatients.getPrenomPatient());
            existingPatient.setAgePatient(updatedPatients.getAgePatient());
            existingPatient.setAddressePatient(updatedPatients.getAddressePatient());
            existingPatient.setSexPatient(updatedPatients.getSexPatient());
            existingPatient.setTelPatient(updatedPatients.getTelPatient());
            existingPatient.setAddressePatient(updatedPatients.getAddressePatient());

            patientRepository.save(existingPatient);

            return ResponseEntity.ok("Patient updated successfully");
        } else {
            // Handle the case when the client with the given ID is not found
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchPatient/{nom}")
    public ResponseEntity<List<Patient>> searchPatientsByName(@PathVariable String nom) {
        List<Patient> patients = patientRepository.findByNomPatientContainingIgnoreCase(nom);

        if (!patients.isEmpty()) {
            return ResponseEntity.ok(patients);
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
