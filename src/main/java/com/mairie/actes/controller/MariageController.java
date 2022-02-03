package com.mairie.actes.controller;

import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dto.ReportingParam;
import com.mairie.actes.service.MariageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("mariage")
public class MariageController {

    @Autowired
    MariageService mariageService;

    @GetMapping
    public ResponseEntity<List<Mariage>> getAllMariage(@RequestParam(value="statut",required = false, defaultValue = "all") String statutActe) {
        if (statutActe.length()>0 && statutActe!=null && !statutActe.equals("all")) {
            return new ResponseEntity<>(mariageService.findAllMariagesByStatutActe(statutActe), HttpStatus.OK);
        }
        if (statutActe.equals("all")){
            return new ResponseEntity<>(mariageService.findAllMariages(), HttpStatus.OK);
        }

        throw new IllegalStateException("Aucun acte de décès trouvé");
    }

    @PostMapping("periode")
    public ResponseEntity<List<Mariage>> getMariageByStatutAndPeriode(@RequestBody ReportingParam params) {

        System.out.println("statut :"+   params.getStatutActe() +"\n dateDebut: "+params.getDateDebut());

        return new ResponseEntity<>(mariageService.findAllMariagesByStatutActeAndPeriode(params.getStatutActe(), params.getDateDebut(),params.getDateFin()), HttpStatus.OK);

    }

    @PostMapping("save")
    public ResponseEntity<Mariage> saveMariage(@RequestBody Mariage mariage) {
        return new ResponseEntity<>(mariageService.enregistrerMariage(mariage), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Mariage> saveMariage(@PathVariable Long id, @RequestBody Mariage mariage) {
        return new ResponseEntity<>(mariageService.enregistrerMariage(mariage), HttpStatus.OK);
    }
}
