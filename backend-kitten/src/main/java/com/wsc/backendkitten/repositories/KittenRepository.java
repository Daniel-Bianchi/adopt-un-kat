package com.wsc.backendkitten.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsc.backendkitten.entities.Kitten;

@Repository
public interface KittenRepository extends JpaRepository<Kitten, Integer> {
    public List<Kitten> findAllKittenByIsAdopted(Boolean isAdopted);
}
