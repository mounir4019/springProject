package com.example.springProject.controllers;  
import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Panier;
import com.example.springProject.sendEmail.EmailService;
import com.example.springProject.sendEmail.EmailDetails;

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
     @Autowired private EmailService emailService;
    @GetMapping({"/commandes"})
    @CrossOrigin(origins = "*")
    private List<Commande> getAllProduits() {
        return this.commandeService.getAllCommandes();
    }
    @PostMapping({"/commandes/{idPanier}"})
    @CrossOrigin(origins = "*")
    private  Commande  creerCommande(@RequestBody Commande commande,@PathVariable("idPanier") int idPanier) {
        Panier panier = panierService.getPanierById(idPanier) ;
        panier.setEtat(1);// panier transformé en commande
        commande.setPanier(panier) ;
        commande.setEtat(0) ; /// en  attente
        commande= this.commandeService.saveOrUpdate(commande);
         EmailDetails emailDetails = new EmailDetails();
         emailDetails.setRecipient(commande.getEmail());         
         emailDetails.setSubject("Votre Commande a été bien Validée. ");
         emailDetails.setMsgBody("Votre Commande a été bien Validée. Elle sera livrée entre 24h et 48h a votre adresse:"+commande.getAdresseLivraison());
         //emailDetails.setAttachment("d:/mounirTabarka.JPG");

        String status  = emailService.sendSimpleMail(emailDetails);         
          return commande ;  
         

    }
 
}
