package com.mairie.actes.dao;

import com.mairie.actes.enums.StatutActe;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table
@Entity
@NoArgsConstructor
@Data
public class Deces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_deces")
    @SequenceGenerator (name = "seq_deces", sequenceName = "seq_deces", allocationSize = 1)
    private Long id;
    private String numeroActe;
    @OneToOne(cascade=CascadeType.ALL)
    private Personne defunt;
    @OneToOne(cascade=CascadeType.ALL)
    private Personne pere;
    @OneToOne(cascade=CascadeType.ALL)
    private Personne mere;
    @Enumerated(EnumType.STRING)
    private StatutActe statutActe = StatutActe.VALIDE;
    private LocalDateTime dateDeces;
    private String lieuDeces;
    private LocalDateTime dateDeclaration;
    private String agentDeclareur;
    private String langueDeclaration;
    private String interprete;
    private String documents;
    private String agentLecteur;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroActe() {
        return numeroActe;
    }

    public void setNumeroActe(String numeroActe) {
        this.numeroActe = numeroActe;
    }

    public StatutActe getStatutActe() {
        return statutActe;
    }

    public void setStatutActe(StatutActe statutActe) {
        this.statutActe = statutActe;
    }

    public Personne getDefunt() {
        return defunt;
    }

    public void setDefunt(Personne defunt) {
        this.defunt = defunt;
    }

    public Personne getPere() {
        return pere;
    }

    public void setPere(Personne pere) {
        this.pere = pere;
    }

    public Personne getMere() {
        return mere;
    }

    public void setMere(Personne mere) {
        this.mere = mere;
    }

    public LocalDateTime getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(LocalDateTime dateDeces) {
        this.dateDeces = dateDeces;
    }

    public String getLieuDeces() {
        return lieuDeces;
    }

    public void setLieuDeces(String lieuDeces) {
        this.lieuDeces = lieuDeces;
    }

    public LocalDateTime getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(LocalDateTime dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public String getAgentDeclareur() {
        return agentDeclareur;
    }

    public void setAgentDeclareur(String agentDeclareur) {
        this.agentDeclareur = agentDeclareur;
    }

    public String getLangueDeclaration() {
        return langueDeclaration;
    }

    public void setLangueDeclaration(String langueDeclaration) {
        this.langueDeclaration = langueDeclaration;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprète(String interprete) {
        this.interprete = interprete;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getAgentLecteur() {
        return agentLecteur;
    }

    public void setAgentLecteur(String agentLecteur) {
        this.agentLecteur = agentLecteur;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
