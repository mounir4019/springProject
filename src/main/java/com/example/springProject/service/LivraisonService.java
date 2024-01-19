package com.example.springProject.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springProject.entity.Livraison; 
import com.example.springProject.repository.LivraisonRepository;

@Service
public class LivraisonService {
    @Autowired
    LivraisonRepository livraisonRepository;
    public List<Livraison> getAllLivraisons() {
        List<Livraison> livraisons = new ArrayList();
        livraisons.addAll(this.livraisonRepository.findAll());
        return livraisons;
    }
    public Livraison getLivraisonById(int id) {
        return this.livraisonRepository.findById(id);
    }
    public Livraison getBonLivraisonClient(String ref) {
        return this.livraisonRepository.findByRefLivraison(  ref);
    }
    
    public List<Livraison>  allLivraisonByCmd(int id) {
        return this.livraisonRepository.findAllLivraisonByCmd(id);
    }
    public Livraison ajouterLivraison(Livraison livraison) {
        return this.livraisonRepository.save(livraison);
    }
    public Livraison modifierLivraison(Livraison livraison) {
        return this.livraisonRepository.save(livraison);
    }
}
