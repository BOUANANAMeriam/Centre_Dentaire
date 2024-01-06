package com.fsts.rendezvous.services;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Consultation  {
    private Integer id;
    private double cout;

    private Date dateConsultation;

    private String description;
    @Transient
   private Facture facture;

    @Transient
  private List<Ordonnance> Listordonnance;
}
