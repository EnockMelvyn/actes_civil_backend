package com.mairie.actes.controller;

import com.mairie.actes.dao.Personne;
import com.mairie.actes.dao.Role;
import com.mairie.actes.repository.RoleRepository;
import com.mairie.actes.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.OK);
    }

}
