package com.example.springProject.controllers; 
import com.example.springProject.entity.Categorie;
import com.example.springProject.entity.Marque;
import com.example.springProject.entity.Produit; 
import com.example.springProject.service.CategorieService;
import com.example.springProject.service.MarqueService;
import com.example.springProject.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ProduitController { 
     @Autowired
    ProduitService produitService;
     @Autowired
    CategorieService categorieService;
     @Autowired
    MarqueService marqueService;
    @GetMapping({"/produits"})
    @CrossOrigin(origins = "*")
    private List<Produit> getAllProduits() {
        return this.produitService.getAllProduits();
    }

    @GetMapping({"/produits/{categorieId}/{marqueId}/{prixMin}/{prixMax}"})
    @CrossOrigin(origins = "*")
    private List<Produit> getMarques(@PathVariable("categorieId") int categorieId,@PathVariable("marqueId") int marqueId,@PathVariable("prixMin")int prixMin,@PathVariable("prixMax")int prixMax) {
        Marque marque = this.marqueService.getMarqueById(marqueId);  
        Categorie categorie = this.categorieService.getCategorieById(categorieId);
        if(marque!=null)  
        return this.produitService.getProduitsByMarquePrix(marqueId,  prixMin,  prixMax);
        if(categorie!=null){
            return this.produitService.getProduitsByCategoriePrix(categorieId,  prixMin,  prixMax);
        }
           
        //return this.produitService.getProduitsByCategorie(categorieId);
        return this.produitService.getAllProduitsByPrix( prixMin,  prixMax);
    }
}
