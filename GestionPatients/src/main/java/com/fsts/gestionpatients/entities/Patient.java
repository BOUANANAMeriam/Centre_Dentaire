package com.fsts.gestionpatients.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsts.gestionpatients.services.RendezVous;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;
    private String nomPatient;
    private String prenomPatient;
    private int agePatient;
    private String sexPatient;
    private String addressePatient;
    private String telPatient;
    private Date dateNaissancePatient;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional = true)
    private DossierMedical dossierMedical;
    @Transient
    private RendezVous rendezVous;

}
