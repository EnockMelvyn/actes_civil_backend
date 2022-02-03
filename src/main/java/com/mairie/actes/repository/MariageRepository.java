package com.mairie.actes.repository;

import com.mairie.actes.dao.Mariage;
import com.mairie.actes.enums.StatutActe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MariageRepository extends JpaRepository<Mariage,Long> {

    List<Mariage> findAllByStatutActe(StatutActe statutActe);

    List<Mariage> findAllByStatutActeAndDateMariageBetween(StatutActe statutActe, LocalDateTime dateMariageStart, LocalDateTime dateMariageEnd);

    List<Mariage> findAllByDateMariageBetween(LocalDateTime dateMariageStart, LocalDateTime dateMariageEnd);
}
