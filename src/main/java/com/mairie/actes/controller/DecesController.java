package com.mairie.actes.controller;

import com.mairie.actes.dao.Deces;
import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dto.ReportingParam;
import com.mairie.actes.service.DecesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("deces")
public class DecesController {

    @Autowired
    DecesService decesService;

    @PostMapping
    public ResponseEntity<Deces> enregistrerDeces (@RequestBody Deces deces) {
        return new ResponseEntity<>(decesService.enregistrerDeces(deces), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Deces> updateDeces (@PathVariable Long id, @RequestBody Deces deces) {
        return new ResponseEntity<>(decesService.updateDeces(deces), HttpStatus.OK);
    }

/*
    @GetMapping
    public ResponseEntity<List<Deces>> getAllDeces () {
        return new ResponseEntity<>(decesService.getAllDeces(), HttpStatus.OK);
    }
*/

    @GetMapping
    public ResponseEntity<List<Deces>> getAllDecesByStatutActe (@RequestParam(value="statut",required = false, defaultValue = "all") String statutActe) {
        if (statutActe.length()>0 && statutActe!=null && !statutActe.equals("all")) {
            return new ResponseEntity<>(decesService.getAllDecesByStatutActe(statutActe), HttpStatus.OK);
        }
        if (statutActe.equals("all")){
            return new ResponseEntity<>(decesService.getAllDeces(), HttpStatus.OK);
        }

        throw new IllegalStateException("Aucun acte de décès trouvé");
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Deces> getDecesById (@PathVariable(value = "id") Long idDeces){
        return new ResponseEntity<>(decesService.getDecesById(idDeces), HttpStatus.OK);
    }

    @PostMapping("periode")
    public ResponseEntity<List<Deces>> getDecesByStatutAndPeriode(@RequestBody ReportingParam params) {

        System.out.println("statut :"+   params.getStatutActe() +"\n dateDebut: "+params.getDateDebut());

        return new ResponseEntity<>(decesService.findAllDecesByStatutActeAndPeriode(params.getStatutActe(), params.getDateDebut(),params.getDateFin()), HttpStatus.OK);

    }
}
