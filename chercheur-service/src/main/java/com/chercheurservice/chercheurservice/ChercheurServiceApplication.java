package com.chercheurservice.chercheurservice;

import com.chercheurservice.chercheurservice.entities.Chercheur;
import com.chercheurservice.chercheurservice.repository.ChercheurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ChercheurServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ChercheurServiceApplication.class, args);
    }

@Bean
    CommandLineRunner start(ChercheurRepository chercheurRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Chercheur.class);
            chercheurRepository.save(new Chercheur(null,"bbb","souka","souka@gmail.com","informatique","0656341275","C1"));
        };
    }
}
