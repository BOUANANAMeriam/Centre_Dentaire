package com.fsts.rendezvous;

import com.fsts.rendezvous.entities.RendezVous;
import com.fsts.rendezvous.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.fsts.rendezvous.services")
public class RendezvousApplication implements CommandLineRunner {
    @Autowired
    RendezVousRepository rendezVousRepository;

    public static void main(String[] args) {
        SpringApplication.run(RendezvousApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<RendezVous> rdvList = new ArrayList<>();
        rdvList.add(new RendezVous(null,"Loca",new Time(12,12,12),true,null,null));
        rdvList.add(new RendezVous(null,"new Date()",new Time(10,10,10),true,null,null));
        rdvList.add(new RendezVous(null,"new Date()",new Time(10,10,10),true,null,null));
        rendezVousRepository.saveAll(rdvList);



    }

}
