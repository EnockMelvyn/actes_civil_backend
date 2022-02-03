package com.mairie.actes.controller;

import com.mairie.actes.dao.Mariage;
import com.mairie.actes.dao.Naissance;
import com.mairie.actes.dto.ReportingParam;
import com.mairie.actes.service.NaissanceService;
import com.mairie.actes.utils.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("naissance")
public class NaissanceController {
    @Autowired
    NaissanceService naissanceService;

    @GetMapping("liste")
    public ResponseEntity<List<Naissance>> getAllNaissance(){
        List<Naissance> naissances = naissanceService.getAllNaissance();
        return new ResponseEntity<>(naissances, HttpStatus.OK);
    }

//    @GetMapping("listeAttente")
//    public ResponseEntity<List<Naissance>> getAllNaissanceAttente(){
//        List<Naissance> naissances = naissanceService.getNaissancesByStatutNaissance(StatutActe.EN_ATTENTE );
//        return new ResponseEntity<>(naissances, HttpStatus.OK);
//    }
//
//    @GetMapping("listeValide")
//    public ResponseEntity<List<Naissance>> getAllNaissanceValide(){
//        List<Naissance> naissances = naissanceService.getNaissancesByStatutNaissance(StatutActe.VALIDE);
//        return new ResponseEntity<>(naissances, HttpStatus.OK);
//    }
    @GetMapping("liste/statut")
    public ResponseEntity<List<Naissance>> getAllNaissancesStatut(@RequestParam String statut){
        List<Naissance> naissances = naissanceService.getNaissancesByStatutNaissance(statut);
        return new ResponseEntity<>(naissances, HttpStatus.OK);
    }

    @PostMapping("periode")
    public ResponseEntity<List<Naissance>> getNaissanceByStatutAndPeriode(@RequestBody ReportingParam params) {

        System.out.println("statut :"+   params.getStatutActe() +"\n dateDebut: "+params.getDateDebut());

        return new ResponseEntity<>(naissanceService.findAllNaissanceByStatutActeAndPeriode(params.getStatutActe(), params.getDateDebut(),params.getDateFin()), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Naissance> enregistrerNaissance(@RequestBody Naissance naissance){
        return new ResponseEntity<>(naissanceService.enregistrerNaissance(naissance), HttpStatus.OK);
    }

    @PutMapping(path = "valider/{id}")
    public ResponseEntity<Naissance> validerNaissance(@PathVariable("id") Long idNaissance){
        return new ResponseEntity<>(naissanceService.validerNaissance(idNaissance), HttpStatus.OK);
    }

    @GetMapping(path= "creerPDF")
    public  ResponseEntity<String> creerPDF() throws FileNotFoundException {
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.createFirstPdf();
        return new ResponseEntity<>("PDF généré avec succès", HttpStatus.OK);
    }

}
