package org.sid;

import org.sid.entities.Traitement;
import org.sid.repositories.TraitementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GestionTraitementApplication implements CommandLineRunner {


	@Autowired
	TraitementRepository traitementRepository ;
	public static void main(String[] args) {
		SpringApplication.run(GestionTraitementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
