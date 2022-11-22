package com.wsc.backendkitten.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsc.backendkitten.entities.Kitten;
import com.wsc.backendkitten.repositories.KittenRepository;

@CrossOrigin(origins = "*") // pour erreurs avec les cors
@RestController
@RequestMapping("/kittens")
public class KittenController {

    @Autowired
    KittenRepository kittenRepository;

    //Liste des chat en fonction de leur statut d'adoption
    @GetMapping
    public List<Kitten> findAllKittenByIsAdopted(Boolean isAdopted) {
        return this.kittenRepository.findAllKittenByIsAdopted(isAdopted); 
    }

    //Un chat par son id
    @GetMapping("/{id}")
    public Optional<Kitten> show(@PathVariable int id) {
        return kittenRepository.findById(id);
    }

    //Ajouter un chat
    @PostMapping
    public Kitten create(@RequestBody Kitten newKitten) {
        return kittenRepository.save(newKitten);
    }
    
}
