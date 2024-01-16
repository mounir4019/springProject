package com.example.springProject.controllers;

import com.example.springProject.entity.Livraison; 
import com.example.springProject.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class LivraisonController {
    @Autowired
    LivraisonService livraisonService;
    @GetMapping({"/administration/livraisons"})
    private List<Livraison> getAllLivraison() {
        return this.livraisonService.getAllLivraisons();
    }

    @GetMapping({"/administration/livraisons/{livraisonId}"})
    private Livraison getLivraison(@PathVariable("livraisonId") int id) {
        return this.livraisonService.getLivraisonById(id);
    }
    @PostMapping({"/administration/livraisons"})
    private Livraison ajouterLivraison(@RequestBody Livraison livraison) {
        return this.livraisonService.ajouterLivraison (livraison);
    }
    @PostMapping({"/administration/livraisons"})
    private Livraison modifierLivraison(@RequestBody Livraison livraison) {
        return this.livraisonService.modifierLivraison (livraison);
    }
}
