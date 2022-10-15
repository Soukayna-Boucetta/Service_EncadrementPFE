package com.chercheurservice.chercheurservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity @AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Chercheur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomchercheur;
    private String prenomchercheur;
    private String Email;
    private String specialite;
    private String tele;
    private String equep;
}
