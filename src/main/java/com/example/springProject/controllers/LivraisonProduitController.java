package com.example.springProject.controllers; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.springProject.entity.LivraisonProduit;
import com.example.springProject.service.LivraisonProduitService;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class LivraisonProduitController {
    @Autowired
    LivraisonProduitService livraisonProduitService;
    @GetMapping({"/administration/livraisonProduits"})
    private List<LivraisonProduit> getAllLivraisonProduit() {
        return this.livraisonProduitService.getAllLivraisonProduits();
    }

    @GetMapping({"/administration/livraisonProduits/{livraisonProduitId}"})
    private LivraisonProduit getLivraisonProduit(@PathVariable("livraisonProduitId") int id) {
        return this.livraisonProduitService.getLivraisonProduitById(id);
    }
    @PostMapping({"/administration/livraisonProduits"})
    private LivraisonProduit ajouterLivraisonProduit(@RequestBody LivraisonProduit livraisonProduit) {
        return this.livraisonProduitService.ajouterLivraisonProduit (livraisonProduit);
    }
    @PostMapping({"/administration/livraisonProduits"})
    private LivraisonProduit modifierLivraisonProduit(@RequestBody LivraisonProduit livraison) {
        return this.livraisonProduitService.modifierLivraisonProduit (livraison);
    }
}
