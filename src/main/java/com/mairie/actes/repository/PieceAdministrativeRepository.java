package com.mairie.actes.repository;

import com.mairie.actes.dao.PieceAdministrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PieceAdministrativeRepository extends JpaRepository<PieceAdministrative, Long> {

    Optional<PieceAdministrative> findByCodePiece(String codePiece);
}
