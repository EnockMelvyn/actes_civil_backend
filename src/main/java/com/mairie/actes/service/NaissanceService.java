package com.mairie.actes.service;

import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dao.Naissance;
import com.mairie.actes.dao.Personne;
import com.mairie.actes.enums.StatutActe;
import com.mairie.actes.repository.NaissanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NaissanceService {

    @Autowired
    NaissanceRepository naissanceRepository;
    @Autowired
    PersonneService personneService;
    public Naissance enregistrerNaissance(Naissance naissance){
        if(naissanceRepository.findNaissanceByNumeroExtrait(naissance.getNumeroExtrait()).isPresent()) {
            throw new RuntimeException("Cet extrait a déjà été enregistré");
        };
        personneService.enregistrerPersonne(naissance.getPere());
        personneService.enregistrerPersonne(naissance.getMere());
        personneService.enregistrerPersonne(naissance.getEnfant());

        return naissanceRepository.save(naissance);
    }

    public List<Naissance> getAllNaissance(){
        return naissanceRepository.findAll();
    }

    public Naissance getNaissanceByEnfant(Personne enfant){
        return naissanceRepository.getNaissanceByEnfant(enfant);
    }

    public List<Naissance> getNaissancesByStatutNaissance(String statut){
        System.out.println(statut);
        if (statut.toUpperCase().equals("VALIDE")) {
            return naissanceRepository.getNaissancesByStatutActe(StatutActe.VALIDE);
        }else if (statut.toUpperCase().equals("EN_ATTENTE")) {
            return naissanceRepository.getNaissancesByStatutActe(StatutActe.EN_ATTENTE);
        }
        System.out.println("je retourne quand même attente");
        return naissanceRepository.findAll();
    }

    public List<Naissance> findAllNaissanceByStatutActeAndPeriode(String statutLibelle, LocalDateTime dateDebut, LocalDateTime dateFin) {
        System.out.println("Statut libellé : "+statutLibelle);
        if (statutLibelle.toUpperCase().equals("ALL")){
            System.out.println(statutLibelle);
            return naissanceRepository.findAllByDateDeclarationBetween(dateDebut, dateFin);
        }
        return naissanceRepository.findAllByStatutActeAndDateDeclarationBetween(StatutActe.valueOf(statutLibelle.toUpperCase()), dateDebut, dateFin);
    }

     public  Naissance validerNaissance(Long id) {
        Naissance naissance= naissanceRepository.getById(id);
        if (naissance.getStatutActe() == StatutActe.VALIDE){
            throw new RuntimeException("Cet extrait a déja été validé");
        }

        naissance.setStatutActe(StatutActe.VALIDE);
        return naissanceRepository.save(naissance);
    }

}
