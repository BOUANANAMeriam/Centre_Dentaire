package com.fsts.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Dent {
    private Long id;

    private String nomDent;
    private int position;
    private Set<Traitement> traitements = new HashSet<>();
}
