package com.fsts.entities;

import java.util.Date;
import java.util.List;

import com.fsts.services.Traitement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "consultations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	 @Column
    private double cout;
	 @Column
    private Date dateConsultation;
	 @Column
    private String description;
	 @Column
	 private Long idTraitement;

	 @Transient
	 private Traitement traitementModel;

	/*
	 * @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Facture> factures;
	 */
	 @ManyToOne
	    @JoinColumn(name = "facture_id") 
	    private Facture facture;
	    
	    @OneToMany(mappedBy = "consultaion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Ordonnance> Listordonnance;
	    
}
