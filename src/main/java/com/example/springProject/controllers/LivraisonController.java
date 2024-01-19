package com.example.springProject.controllers;

import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Livraison;
import com.example.springProject.entity.LivraisonProduit;
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.entity.User;
import com.example.springProject.sendEmail.EmailDetails;
import com.example.springProject.sendEmail.EmailService;
import com.example.springProject.entity.EntrepriseLivaison;
import com.example.springProject.service.CommandeService;
import com.example.springProject.service.LivraisonService;
import com.example.springProject.service.PanierService;
import com.example.springProject.service.ProduitService;
import com.example.springProject.service.UserService;
import com.example.springProject.servicesDivers.ServiceDivers;
import com.example.springProject.service.EntrepriseLivaisonService;
import com.example.springProject.service.LivraisonProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class LivraisonController {
    @Autowired
    LivraisonService livraisonService;
    @Autowired
    CommandeService commandeService;
    @Autowired
    UserService userService;
    @Autowired
    EntrepriseLivaisonService entrepriseLivaisonService;
        @Autowired
    ProduitService produitService;
    @Autowired
    LivraisonProduitService livraisonProduitService; 
      @Autowired
    PanierService panierService;
    @Autowired private EmailService emailService;
    @GetMapping({"/administration/livraisons"})
    private List<Livraison> getAllLivraison() {
        return this.livraisonService.getAllLivraisons();
    }

    @GetMapping({"/administration/livraisons/{livraisonId}"})
    private Livraison getLivraison(@PathVariable("livraisonId") int id) {
        return this.livraisonService.getLivraisonById(id);
    }
    @GetMapping({"/administration/AllLivraisonByCmd/{commandeId}"})
    private List<Livraison> allLivraisonByCmd(@PathVariable("commandeId") int id) {
        return this.livraisonService.allLivraisonByCmd(id);
    }
    @GetMapping({"/administration/bonLivraison/{refLivraison}"})
    @CrossOrigin(origins = "*")
    private  Livraison  getBonLivraisonClient(@PathVariable("refLivraison") String refLivraison) {
        return this.livraisonService.getBonLivraisonClient(refLivraison);
    }
    @PutMapping({"/administration/livraisons"})
    private Livraison modifierLivraison(@RequestBody Livraison livraison) {
        return this.livraisonService.modifierLivraison (livraison);
    }
    @PostMapping({"/administration/livraisons/{commandeId}/{livreurId}/{idEntrepriseLivraisonSelect}"})
    private Livraison ajouterLivraison(@RequestBody Livraison livraison,@PathVariable("commandeId") int commandeId,@PathVariable("livreurId") int livreurId,@PathVariable("idEntrepriseLivraisonSelect") int idEntrepriseLivraisonSelect) {
        System.out.println(livraison.getNomLivreur());
        Commande commande=commandeService.getCommande(commandeId);
        User  user =new User();
        EntrepriseLivaison entrepriseLivraison =new EntrepriseLivaison();
        if(livreurId>0)
        {    user=userService.getUserById(livreurId);
             livraison.setUser(user);
        }else{
            entrepriseLivraison=entrepriseLivaisonService.getEntrepriseLivaisonById(idEntrepriseLivraisonSelect);
            livraison.setEntrepriseLivaison(entrepriseLivraison);
        }
        ////////Mettre ajour etatPanier=2~ en cours de livraison////////////
        Panier panier=panierService.getPanierById(commande.getPanier().getId());
        panier.setEtat(2);// panier en livraison
        ////////Mettre ajour etatCommande=1~ en cours de livraison//////////// 
        commande.setPanier(panier) ; /// en  livraison 
        commande.setEtat(1) ; /// en  livraison 
        //commande= this.commandeService.saveOrUpdate(commande);
         ///////////////
         livraison.setCommande(commande);
         livraison.setReferenceLivraison(ServiceDivers.generateRandomCode(20));

         EmailDetails emailDetails = new EmailDetails();
         emailDetails.setRecipient(commande.getEmail());         
         emailDetails.setSubject("Votre Commande est en cours de livraison. ");
         emailDetails.setMsgBody("Votre Commande est affectée à un livreur. Elle sera livrée très bientôt a votre adresse:"+commande.getAdresseLivraison());
         //emailDetails.setAttachment("d:/mounirTabarka.JPG"); 
        String status  = emailService.sendSimpleMail(emailDetails);         
       
        return this.livraisonService.ajouterLivraison (livraison);
    }
   @PostMapping("/administration/livraisonProduit/{livraisonId}/{produitId}")
   @CrossOrigin(origins = "*")
   private  LivraisonProduit  saveLivraisonProduit( @RequestBody LivraisonProduit livraisonProduit,@PathVariable("livraisonId") int livraisonId,@PathVariable("produitId") int produitId ) { 
    livraisonProduit.setLivraison(livraisonService.getLivraisonById(livraisonId));
    livraisonProduit.setProduit(produitService.getProduitById(produitId)); 
     return  livraisonProduitService.saveOrUpdate(livraisonProduit); 
    }
}
