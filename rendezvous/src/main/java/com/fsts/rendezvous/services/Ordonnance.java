package com.fsts.rendezvous.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

import java.sql.Date;

public class Ordonnance {
    private Integer Id ;
    private Date Date_prescription;

   private String Description ;
   @Transient
   private Consultation consultaion;

}
