package org.sdi.compte_service.entities;

import org.sdi.compte_service.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2",types = Compte.class)
public interface ComptProj2 {
     double getSolde();
     TypeCompte getType();
}
