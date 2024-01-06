package com.fsts.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fsts.services.Traitement;

import java.util.List;

@FeignClient(name = "traitemnt-service",url = "http://localhost:8083")
public interface OpenFeignTraitement {
    @GetMapping(value =  "/traitement")
    List<Traitement> listePatients();

    @GetMapping(value = "/traitement/{id}")
    Traitement getTraitementById(@PathVariable Long id);

}
