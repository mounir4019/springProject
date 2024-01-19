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

import java.time.Instant;
import java.util.Date;
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
    @GetMapping({"administration/commandes"})
    @CrossOrigin(origins = "*")
    private List<Commande> getAllCommandes() {
        return this.commandeService.getAllCommandes();
    }
    @GetMapping({"administration/commandes/{idCommande}"})
    @CrossOrigin(origins = "*")
    private Commande getCommande(@PathVariable("idCommande") int idCommande) {
        return this.commandeService.getCommande(idCommande);
    }
    @GetMapping({"/administration/commandes/validation/{idCommande}"})
    ////  Get; je n'est pas besoin du body
    @CrossOrigin(origins = "*")
    private  Commande validerCommande(@PathVariable("idCommande") int idCommande) { 
      Commande commande = commandeService.getCommandeById(idCommande);
      Panier panier =panierService.getPanierById(commande.getPanier().getId());
      panier.setEtat(3);// indication à un panier est Livrée
      commande.setEtat(2);//// Commande est Livrée
      commande.setPanier(panier);
      commande.setDateValidation(Date.from(Instant.now()));
      //   ++++++++++++   changer l'etat du Livraison à 1 cad livraison terminé
      //  +++++++++++++   ne pas oublier livraison total=2 ou partielle=1 creer une interface dans le frontEnd
        return this.commandeService.saveOrUpdate(commande);
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
