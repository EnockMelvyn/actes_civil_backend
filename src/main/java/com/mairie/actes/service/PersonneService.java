package com.mairie.actes.service;

import com.mairie.actes.dao.Personne;
import com.mairie.actes.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class PersonneService {
    @Autowired
    PersonneRepository personneRepository;

    public Personne enregistrerPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonne() {
        return  personneRepository.findAll();
    }
}
