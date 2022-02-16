package com.mairie.actes.dao;

import com.mairie.actes.enums.StatutActe;
import com.mairie.actes.enums.TypeNaissance;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Data
@Getter
@Setter
public class Naissance implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_naissance")
    @SequenceGenerator (name = "seq_naissance", sequenceName = "seq_naissance", allocationSize = 1)
    private Long id;
    private String numeroExtrait;
    @Enumerated(EnumType.STRING)
    private TypeNaissance typeNaissance;
    @Enumerated(EnumType.STRING)
    private StatutActe statutActe = StatutActe.VALIDE;
    @ManyToOne
    private Personne enfant;
    @ManyToOne(fetch = FetchType.EAGER)
    private Personne pere;
    private String pereExtrait;
    @ManyToOne(fetch = FetchType.EAGER)
    private Personne mere;
    private String mereExtrait;
    private LocalDateTime dateDeclaration;
    private String agentDeclareur;
    private String langueDeclaration;
    private String interprete;
    private String documents;
    private String agentLecteur;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate modifiedAt;
    private String modifiedBy;

    private String certificatNaissance;

    public String getNumeroExtrait() {
        return numeroExtrait;
    }

    public void setNumeroExtrait(String numeroExtrait) {
        this.numeroExtrait = numeroExtrait;
    }

    public StatutActe getStatutActe() {
        return statutActe;
    }

    public void setStatutActe(StatutActe statutActe) {
        this.statutActe = statutActe;
    }

    public TypeNaissance getTypeNaissance() {
        return typeNaissance;
    }

    public void setTypeNaissance(TypeNaissance typeNaissance) {
        this.typeNaissance = typeNaissance;
    }

    public Personne getEnfant() {
        return enfant;
    }

    public void setEnfant(Personne enfant) {
        this.enfant = enfant;
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

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getPereExtrait() {
        return pereExtrait;
    }

    public void setPereExtrait(String pereExtrait) {
        this.pereExtrait = pereExtrait;
    }

    public String getMereExtrait() {
        return mereExtrait;
    }

    public void setMereExtrait(String mereExtrait) {
        this.mereExtrait = mereExtrait;
    }

    public String getCertificatNaissance() {
        return certificatNaissance;
    }

    public void setCertificatNaissance(String certificatNaissance) {
        this.certificatNaissance = certificatNaissance;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
