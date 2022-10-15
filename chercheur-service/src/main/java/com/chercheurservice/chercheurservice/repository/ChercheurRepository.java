package com.chercheurservice.chercheurservice.repository;

import com.chercheurservice.chercheurservice.entities.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChercheurRepository extends JpaRepository<Chercheur,Long> {
}
