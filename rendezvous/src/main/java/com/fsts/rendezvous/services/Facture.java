package com.fsts.rendezvous.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Facture {
    private Integer id;
    private double montantTotal;
    private double montantPaye;
    private Date dateFacturation;
    private String modePaiement;
    private List<Consultation> consultations;

}
