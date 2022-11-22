package com.wsc.backendkitten.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<Kitten> findAllKittenByIsAdopted(Boolean isAdopted) {
        return this.kittenRepository.findAllKittenByIsAdopted(isAdopted = false); 
    }
    
}
