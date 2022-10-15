package org.sdi.compte_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = Compte.class)
public interface ComptProj1 {
    public Long getCode();
    public double getSolde();
}
