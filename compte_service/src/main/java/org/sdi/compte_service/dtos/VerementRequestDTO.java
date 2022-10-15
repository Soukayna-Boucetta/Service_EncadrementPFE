package org.sdi.compte_service.dtos;

import lombok.Data;

@Data
public class VerementRequestDTO {
    private Long codeSource;
    private Long codeDestination;
    private double montant;

}
