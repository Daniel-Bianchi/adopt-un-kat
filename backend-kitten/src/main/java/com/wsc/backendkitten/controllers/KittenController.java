package com.wsc.backendkitten.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //Adopter un chat
    @PostMapping
    public Kitten adopKitten(int id) {
        Kitten kittenToAdopt = kittenRepository.findById(id).get();

        kittenToAdopt.setIsAdopted(true);

        return kittenRepository.save(kittenToAdopt);
    }

    //Modifier un chat
    @PutMapping("/{id}")
    public Kitten update(@PathVariable int id, @RequestBody Kitten updateKitten) {
        Kitten kittenToUpdate = kittenRepository.findById(id).get(); //On récupère le chat que l'on veut modifier
        //Modifier l'age
        kittenToUpdate.setAge(updateKitten.getAge());
        //Modifier le nom
        kittenToUpdate.setName(updateKitten.getName());
        //Modifier la couleur
        kittenToUpdate.setColor(updateKitten.getColor());
        //Modifier la race
        kittenToUpdate.setRace(updateKitten.getRace());
        //Modifier le genre
        kittenToUpdate.setGenre(updateKitten.getGenre());
        //Modfier l'image
        kittenToUpdate.setImageUrl(updateKitten.getImageUrl());

        return kittenRepository.save(kittenToUpdate);
    }

    //Supprimer un chat
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        kittenRepository.deleteById(id);
        return true;
    }

    
}
