package com.mairie.actes.service;

import com.mairie.actes.dao.Mariage;
import com.mairie.actes.enums.StatutActe;
import com.mairie.actes.repository.MariageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MariageService {

    @Autowired
    MariageRepository mariageRepository;

    public Mariage enregistrerMariage(Mariage mariage) {

        return mariageRepository.save(mariage);
    }

    public List<Mariage> findAllMariages(){
        return mariageRepository.findAll();
    }

    public List<Mariage> findAllMariagesByStatutActe(String statutLibelle) {
        return mariageRepository.findAllByStatutActe(StatutActe.valueOf(statutLibelle.toUpperCase()));
    }

    public List<Mariage> findAllMariagesByStatutActeAndPeriode(String statutLibelle, LocalDateTime dateDebut, LocalDateTime dateFin) {
        System.out.println("Statut libellé : "+statutLibelle);
        if (statutLibelle.toUpperCase().equals("ALL")){
            System.out.println(statutLibelle);
            return mariageRepository.findAllByDateMariageBetween(dateDebut, dateFin);
        }
        return mariageRepository.findAllByStatutActeAndDateMariageBetween(StatutActe.valueOf(statutLibelle.toUpperCase()), dateDebut, dateFin);
    }
}
