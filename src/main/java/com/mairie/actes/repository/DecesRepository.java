package com.mairie.actes.repository;

import com.mairie.actes.dao.Deces;
import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dao.Personne;
import com.mairie.actes.enums.StatutActe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DecesRepository extends JpaRepository<Deces,Long> {


    Optional<Deces> findByDefunt(Personne defunt);

    Optional<Deces> findByNumeroActe(String numeroActe);

    List<Deces> findAllByStatutActe(StatutActe statutActe);

    List<Deces> findAllByStatutActeAndDateDecesBetween(StatutActe statutActe, LocalDateTime dateDecesStart, LocalDateTime dateDecesEnd);

    List<Deces> findAllByDateDecesBetween(LocalDateTime dateMariageStart, LocalDateTime dateMariageEnd);
}
