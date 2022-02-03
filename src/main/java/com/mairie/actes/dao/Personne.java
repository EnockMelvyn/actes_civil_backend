package com.mairie.actes.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table
@Entity
@NoArgsConstructor
@Data
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_personne")
    @SequenceGenerator (name = "seq_personne", sequenceName = "seq_personne", allocationSize = 1)
    private Long id;
    private String nom;
    private String prenoms;
    private String lieuNaissance;
    private LocalDateTime dateHeureNaissance;
    private String nationalite;
    private String lieuResidence;
    private String contact;
    private String email;
    private String profession;
}
