package com.example.springProject.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.springProject.entity.LivraisonProduit; 
import com.example.springProject.repository.LivraisonProduitRepository;

@Service
public class LivraisonProduitService {
    @Autowired
    LivraisonProduitRepository livraisonProduitRepository;
    public List<LivraisonProduit> getAllLivraisonProduits() {
        List<LivraisonProduit>  livraisonProduits = new ArrayList();
        livraisonProduits.addAll(this.livraisonProduitRepository.findAll());
        return livraisonProduits;
    }
    public LivraisonProduit getLivraisonProduitById(int id) {
        return this.livraisonProduitRepository.findById(id);
    }
    
    public LivraisonProduit ajouterLivraisonProduit(LivraisonProduit livraisonProduit) {
        return this.livraisonProduitRepository.save(livraisonProduit);
    }
    public LivraisonProduit modifierLivraisonProduit(LivraisonProduit livraisonProduit) {
        return this.livraisonProduitRepository.save(livraisonProduit);
    }
} 
