package com.fsts.rendezvous.entities;

import com.fsts.rendezvous.services.Consultation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRendezVous;
	@Column
	private String dateHeureRD;
	@Column
	private Time heureDebut;
//    private String heureFin;
	@Column
    private boolean disponible;

	private Integer idConsultation;

	@Transient
	private  Consultation consultation;
	
	

}
