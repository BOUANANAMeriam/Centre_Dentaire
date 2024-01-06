package com.fsts.rendezvous.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "consultation-service",url = "http://localhost:8091")
public interface FeignConsultation {

    @GetMapping(value =  "/Consultations")
    List<Consultation> listeConsultations();

    @GetMapping(value = "/consultations/{id}")
    Consultation getConsultationById(@PathVariable Integer id);
}
