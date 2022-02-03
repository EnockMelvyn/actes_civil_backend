package com.mairie.actes.controller;

import com.mairie.actes.dao.PieceAdministrative;
import com.mairie.actes.repository.PieceAdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("pieceAdministrative")
public class PieceAdministrativeController {
    @Autowired
    PieceAdministrativeRepository pieceAdminRepo;

    @GetMapping
    public ResponseEntity<List<PieceAdministrative>> getAllPieceAdministrative(){
        return new ResponseEntity<>(pieceAdminRepo.findAll(), HttpStatus.OK);
    }
}
