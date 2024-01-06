package com.fsts.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "traitement-service",url = "http://localhost:8083")
public interface OpenFeignRDV {
  /*  @GetMapping(value =  "/traitement")
    List<RendezVous> listePatients();

    @GetMapping(value = "/traitement/{id}")
    RendezVous getRdvById(@PathVariable Integer id);

   */
}


