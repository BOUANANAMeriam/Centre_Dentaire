package com.fsts.gestionpatients;

import com.fsts.gestionpatients.entities.DossierMedical;
import com.fsts.gestionpatients.entities.Patient;
import com.fsts.gestionpatients.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class GestionPatientsApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository ;

    public static void main(String[] args) {
        SpringApplication.run(GestionPatientsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        ArrayList<Patient> patients = new ArrayList<>();
        Patient p1 = new Patient(null,"lhrech","ilham",22,"femme","casa","0654678780",new Date(),null,null);
        Patient p2 = new Patient(null,"najia","lahrech",12,"femme","casa","0654289100",new Date(), null,null);
        Patient p3= new Patient(null,"amin","mohamed",38,"homme","casa","0635799022",new Date(),null,null);

        Patient p4= new Patient(null,"tOTO","titi",24,"femme","casa","0635799022",new Date(),null,null);
        Patient p5= new Patient(null,"test","test",10,"homme","casa","0635799022",new Date(),null,null);

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);
        patients.add(p5);
        for (Patient patient : patients) {
            DossierMedical dossierMedical = new DossierMedical();
            dossierMedical.setGroupeSanguin("O+");
            dossierMedical.setAntecedents("Aucun");
            dossierMedical.setAllergies("Aucune");
            dossierMedical.setRemarques("Aucune");
            dossierMedical.setPatient(patient);
            // Associez le dossier médical au patient
            patient.setDossierMedical(dossierMedical);
        }

        patientRepository.saveAll(patients);
    }


}
