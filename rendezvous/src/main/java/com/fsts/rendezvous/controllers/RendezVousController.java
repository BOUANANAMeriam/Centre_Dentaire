package com.fsts.rendezvous.controllers;

import com.fsts.rendezvous.entities.RendezVous;
import com.fsts.rendezvous.repositories.RendezVousRepository;
import com.fsts.rendezvous.services.Consultation;
import com.fsts.rendezvous.services.FeignConsultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
	
	@Autowired
	RendezVousRepository rendezVousRepository;

	@Autowired
	FeignConsultation feignConsultation;
	
	@PostMapping
	public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {
		return rendezVousRepository.save(rendezVous);
	}
	
	@GetMapping("/{id}")
	public RendezVous getRendezVousByID(@PathVariable int id) {

		RendezVous rendezVous = rendezVousRepository.findById(id).get();
		Consultation consultation = feignConsultation.getConsultationById(rendezVous.getIdRendezVous());
		rendezVous.setConsultation(consultation);
		return rendezVous;
		
	}
	
	@GetMapping
	public List<RendezVous> getAllRendezVous(){
		return rendezVousRepository.findAll();
	}
	
//	@PutMapping("/{id}")
//	public RendezVous updateRendezVous(@RequestBody RendezVous rendezVous) {
//		Optional<RendezVous> optional= rendezVousRepository.findById(rendezVous.getIdRendezVous());
//		if(optional.isEmpty())
//			return null;
//		return rendezVousRepository.save(rendezVous);
//	}
	
	
	@GetMapping("/availableRD")
	public List<RendezVous> getAvailableRendezVous() {
        // Récupérer tous les rendez-vous depuis la base de données
        List<RendezVous> allRendezVous = rendezVousRepository.findAll();

        // Filtrer les rendez-vous pour n'inclure que ceux qui sont disponibles
        List<RendezVous> availableRendezVous = allRendezVous.stream()
                .filter(rendezVous -> rendezVous.isDisponible()) // Ajoutez une méthode isDisponible() à votre entité RendezVous
                .collect(Collectors.toList());

        return availableRendezVous;
    }
	
	@PutMapping("/{id}")
    public RendezVous save (@PathVariable Integer id ,@RequestBody RendezVous RD){
		RD.setIdRendezVous(id);
		return rendezVousRepository.save(RD);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRendezVous(@PathVariable int id) {
		rendezVousRepository.deleteById(id);
	}


	/*
	@GetMapping("/byDate/{date}")
	public List<RendezVous> getRendezVousByDate(@PathVariable String date) {

		List<RendezVous> allRendezVous = rendezVousRepository.findAll();

		List<RendezVous> rendezVousByDate = allRendezVous.stream()
				.filter(rendezVous -> {
                    return rendezVous.getDateHeureRD().toLocalDate().toString().equals(date);
                }) // Assuming getDateHeureRD() returns a LocalDateTime
				.collect(Collectors.toList());

		return rendezVousByDate;
	}
	@GetMapping("/ToDay")
	public List<RendezVous> getRendezVousToDay() {

		List<RendezVous> allRendezVous = rendezVousRepository.findAll();
		List<RendezVous> rendezVousByDate = allRendezVous.stream()
				.filter(rendezVous -> rendezVous.getDateHeureRD().toLocalDate().equals(LocalDate.now())) // Assuming getDateHeureRD() returns a LocalDateTime
				.collect(Collectors.toList());

		return rendezVousByDate;
	}

	 */
}
