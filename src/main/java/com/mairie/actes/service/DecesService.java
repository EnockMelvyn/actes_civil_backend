package com.mairie.actes.service;

import com.mairie.actes.dao.Deces;
import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dao.Naissance;
import com.mairie.actes.dao.Personne;
import com.mairie.actes.enums.StatutActe;
import com.mairie.actes.repository.DecesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DecesService {
    @Autowired
    PersonneService personneService;

    @Autowired
    DecesRepository decesRepository;

    public Deces enregistrerDeces(Deces deces){
        if(decesRepository.findByNumeroActe(deces.getNumeroActe()).isPresent()) {
            throw new RuntimeException("Ce numéro d'acte de décès a déjà été enregistré");
        };

        personneService.enregistrerPersonne(deces.getPere());
        personneService.enregistrerPersonne(deces.getMere());
        personneService.enregistrerPersonne(deces.getDefunt());

        deces.setCreatedAt(LocalDateTime.now());
        return decesRepository.save(deces);
    }

    public Deces getDecesById(Long idDeces){ return decesRepository.findById(idDeces).get();}
    public List<Deces> getAllDeces(){
        return decesRepository.findAll();
    }
    public List<Deces> getAllDecesByStatutActe(String statutLibelle){
        /*System.out.println(statutLibelle);
        if (statutLibelle.equals("valide")) {
            return decesRepository.findAllByStatutActe(StatutActe.VALIDE);
        }else if (statutLibelle.equals("attente")) {
            return decesRepository.findAllByStatutActe(StatutActe.EN_ATTENTE);
        }
        System.out.println("je retourne quand même attente");
        return decesRepository.findAll();*/
        return decesRepository.findAllByStatutActe(StatutActe.valueOf(statutLibelle.toUpperCase()));
    }

    public List<Deces> findAllDecesByStatutActeAndPeriode(String statutLibelle, LocalDateTime dateDebut, LocalDateTime dateFin) {
        System.out.println("Statut libellé : "+statutLibelle);
        if (statutLibelle.toUpperCase().equals("ALL")){
            System.out.println(statutLibelle);
            return decesRepository.findAllByDateDecesBetween(dateDebut, dateFin);
        }
        return decesRepository.findAllByStatutActeAndDateDecesBetween(StatutActe.valueOf(statutLibelle.toUpperCase()), dateDebut, dateFin);
    }
    public Deces updateDeces(Deces deces){
       /* Deces oldDeces = decesRepository.findById(deces.getId()).get();
        deces.setCreatedAt(oldDeces.getCreatedAt());
        deces.setCreatedBy(oldDeces.getCreatedBy());
        deces.setModifiedAt(LocalDateTime.now());
        */
        System.out.println(deces.getStatutActe());
        return decesRepository.save(deces);
    }
}
