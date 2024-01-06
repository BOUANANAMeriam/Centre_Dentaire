package com.fsts.entities;

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
@Table(name = "ordonnance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordonnance {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ;

    @Column(name = "Date_prescription")
    private Date Date_prescription;

    @Column(name = "Description ")
    private String Description ;
    
    
	 @ManyToOne
	    @JoinColumn(name = "id_consultation") // Assurez-vous de spécifier le nom correct de la colonne de clé étrangère
	 @JsonIgnore   
	 private Consultation consultaion;


}
