package com.example.springProject.controllers;  
import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.entity.Produit;
import com.example.springProject.sendEmail.EmailService;
import com.example.springProject.sendEmail.EmailDetails;

import com.example.springProject.service.CommandeService;
import com.example.springProject.service.PanierService;
import com.example.springProject.service.ProduitService;
import com.example.springProject.servicesDivers.ServiceDivers;

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
    ServiceDivers serviceDivers;
      @Autowired
    PanierService panierService;
      @Autowired
    ProduitService produitService;
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
        List<PanierProduit> panierProduit = panier.getPanierProduits();
        for(int i=0;i<panierProduit.size();i++){
          Produit produit = produitService.getProduitById(panierProduit.get(i).getProduit().getId());
          panierProduit.get(i).setPrixFacture(produit.getPrix());
        }
        panier.setEtat(1);// panier transformé en commande
        commande.setPanier(panier) ;
        commande.setEtat(0) ; /// en  attente
        commande.setReferenceFacture(ServiceDivers.generateRandomCode(20));
        commande= this.commandeService.saveOrUpdate(commande);
         EmailDetails emailDetails = new EmailDetails();
         emailDetails.setRecipient(commande.getEmail());         
         emailDetails.setSubject("Votre Commande a été bien Validée. ");
         emailDetails.setMsgBody("Votre Commande a été bien Validée. Elle sera livrée entre 24h et 48h a votre adresse:"+commande.getAdresseLivraison());
         //emailDetails.setAttachment("d:/mounirTabarka.JPG"); 
        String status  = emailService.sendSimpleMail(emailDetails);         
          return commande ;   
    }
    @GetMapping({"/espaceClient/mesCommandes/{idUser}"})
    @CrossOrigin(origins = "*")
    private List<Commande> mesCommandesClient(@PathVariable("idUser") int idUser) {
        return this.commandeService.getMesCommandesClient(idUser);
    }
    @GetMapping({"/espaceClient/maFacture/{refFacture}"})
    @CrossOrigin(origins = "*")
    private  Commande  maFactureClient(@PathVariable("refFacture") String refFacture) {
        return this.commandeService.getmaFactureClient(refFacture);
    }
}
