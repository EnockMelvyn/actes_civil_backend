package com.mairie.actes.dao;

import com.mairie.actes.enums.RegimeMariage;
import com.mairie.actes.enums.StatutActe;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
@NoArgsConstructor
@Data
public class Mariage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mariage")
    @SequenceGenerator(name = "seq_mariages", sequenceName = "seq_mariage", allocationSize = 1)
    private Long id;
    private String numeroActe;
    private LocalDateTime dateMariage;
    private String lieuMariage;

    private String celebrant;
    @OneToOne(cascade=CascadeType.ALL)
    private Personne epoux;
    private String epouxPere;
    private String epouxMere;

    @OneToOne(cascade=CascadeType.ALL)
    private Personne epouse;

    private String epousePere;
    private String epouseMere;

    @Enumerated(EnumType.STRING)
    private RegimeMariage regimeEpoux;
    @Enumerated(EnumType.STRING)
    private RegimeMariage regimeEpouse;

    @Enumerated(EnumType.STRING)
    private StatutActe statutActe = StatutActe.EN_ATTENTE;
    private String epouxTemoin;
    private String epouseTemoin;

    private String agentDeclareur;
    private String langueDeclaration;
    private String interprète;
    private String documents;
    private String agentLecteur;

    @OneToMany(fetch = FetchType.LAZY)
    private List<PieceAdministrative> pieces;

    private LocalDateTime rendezvous;
    private boolean rendezvousIsOk;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
