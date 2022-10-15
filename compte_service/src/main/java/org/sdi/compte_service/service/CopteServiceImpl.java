package org.sdi.compte_service.service;

import org.sdi.compte_service.entities.Compte;
import org.sdi.compte_service.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CopteServiceImpl implements CopteService {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public void virment(Long codeSource, Long codeDestination, double montant) {
        Compte c1=compteRepository.getById(codeSource);
        Compte c2=compteRepository.getById(codeSource);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
        compteRepository.save(c1);
        compteRepository.save(c2);

    }
}
