package com.example.springProject.controllers;  
import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Panier;
import com.example.springProject.service.CommandeService;
import com.example.springProject.service.PanierService;

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
public class CommandeController { 
     @Autowired
    CommandeService commandeService;
      @Autowired
    PanierService panierService;
     
    @GetMapping({"/commandes"})
    @CrossOrigin(origins = "*")
    private List<Commande> getAllProduits() {
        return this.commandeService.getAllCommandes();
    }
    @PostMapping({"/commandes/{idPanier}"})
    @CrossOrigin(origins = "*")
    private  Commande  creerCommande(@RequestBody Commande commande,@PathVariable("idPanier") int idPanier) {
        Panier panier = panierService.getPanierById(idPanier) ;
        commande.setPanier(panier) ;
        return this.commandeService.saveOrUpdate(commande ); 
    }
 
}
