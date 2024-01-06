package com.fsts.gestionpatients.services;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class RendezVous {
    private int idRendezVous;

    private String dateHeureRD;

    private Time heureDebut;

    private boolean disponible;
}
