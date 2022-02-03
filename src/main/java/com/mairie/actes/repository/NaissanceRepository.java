package com.mairie.actes.repository;

import com.mairie.actes.dao.Deces;
import com.mairie.actes.dao.Naissance;
import com.mairie.actes.dao.Personne;
import com.mairie.actes.enums.StatutActe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NaissanceRepository extends JpaRepository<Naissance,Long> {

    Naissance getNaissanceByEnfant(Personne enfant);

    List<Naissance> getNaissancesByStatutActe(StatutActe statutActe);

    Optional<Naissance> findNaissanceByNumeroExtrait(String numeroExtrait);

    List<Naissance> findAllByStatutActeAndDateDeclarationBetween(StatutActe statutActe, LocalDateTime dateNaissanceStart, LocalDateTime dateNaissanceEnd);

    List<Naissance> findAllByDateDeclarationBetween(LocalDateTime dateNaissanceStart, LocalDateTime dateNaissanceEnd);

}
