package com.fsts.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "factures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @Column(name = "montant_total")
    private double montantTotal;

    @Column(name = "montant_paye")
    private double montantPaye;

    @Column(name = "date_facturation")
    private Date dateFacturation;

    @Column(name = "mode_paiement")
    private String modePaiement;
	
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;
   
   

	}