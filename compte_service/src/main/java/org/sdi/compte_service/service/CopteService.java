package org.sdi.compte_service.service;

public interface CopteService  {
    void virment(Long codeSource,Long codeDestination,double montant);
}
