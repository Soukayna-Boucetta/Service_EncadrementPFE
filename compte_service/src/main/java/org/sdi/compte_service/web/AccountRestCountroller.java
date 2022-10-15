package org.sdi.compte_service.web;

import org.sdi.compte_service.dtos.VerementRequestDTO;
import org.sdi.compte_service.service.CopteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestCountroller {
    @Autowired
    private CopteService compteService;
    @PutMapping(path = "comptes/virement")
    public void virement(@RequestBody VerementRequestDTO request){
        compteService.virment(request.getCodeSource(),request.getCodeDestination(),request.getMontant());

    }

}
