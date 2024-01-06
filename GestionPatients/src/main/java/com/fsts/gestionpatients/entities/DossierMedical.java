package com.fsts.gestionpatients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DossierMedical {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupeSanguin;
    private String antecedents;
    private String allergies;
    private String remarques;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPatient")
    @JsonIgnore
    private Patient patient;
}
