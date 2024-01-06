package com.fsts.gestionpatients.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rendezvous",url = "http://localhost:9092")
public interface FeignRendezVous {

    @GetMapping(value =  "/rendezvous")
    List<RendezVous> listePatients();

    @GetMapping(value = "/rendezvous/{id}")
    RendezVous getRdvById(@PathVariable Integer id);
}
