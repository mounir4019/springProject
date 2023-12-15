package com.example.springProject.controllers; 
import com.example.springProject.entity.Categorie;
import com.example.springProject.entity.Marque;
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.Produit; 
import com.example.springProject.service.CategorieService;
import com.example.springProject.service.MarqueService;
import com.example.springProject.service.ProduitService;

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
    @GetMapping({"/produits/{id}"})
    @CrossOrigin(origins = "*")
    private  Produit  getProduit(@PathVariable("id") int id) {
        return this.produitService.getProduitById(id);
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
   @PostMapping("/produit/{marqueId}")
   @CrossOrigin(origins = "*")
   private  Produit  saveProduit( @RequestBody Produit produit,@PathVariable("marqueId") int marqueId) {  
    produit.setMarque(marqueService.getMarqueById(marqueId)); 
     return  produitService.saveOrUpdate(produit); 
    }
   @PutMapping("/produit/{marqueId}")
   @CrossOrigin(origins = "*")
   private  Produit  updateProduit( @RequestBody Produit produit,@PathVariable("marqueId") int marqueId) {  
    produit.setMarque(marqueService.getMarqueById(marqueId)); 
     return  produitService.saveOrUpdate(produit); 
    }

}
