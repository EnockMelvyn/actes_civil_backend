package com.mairie.actes.controller;

import com.mairie.actes.dao.Personne;
import com.mairie.actes.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("personne")
public class PersonneController {
    @Autowired
    PersonneService personneService;

    @GetMapping
    public ResponseEntity<List<Personne>> getAllPersonne() {
        return new ResponseEntity<>(personneService.getAllPersonne(), HttpStatus.OK);
    }

}
