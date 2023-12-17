package com.example.springProject.controllers;
 
import com.example.springProject.entity.Produit;
import com.example.springProject.entity.ProduitImages; 
import com.example.springProject.service.ProduitImagesService;
import com.example.springProject.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ProduitImagesController {
    @Autowired
    ProduitImagesService produitImagesService;
     @Autowired
    ProduitService produitService;

    @GetMapping({"/produitImages/{produitId}"})
    @CrossOrigin(origins = "*")
    private List<ProduitImages> getAllProduitImages(@PathVariable("produitId") int id) {
        Produit produit=produitService.getProduitById(id);
        return this.produitImagesService.getProduitImagesByProduit(produit);
    } 
   /*  @GetMapping({"/produitImages/{produitImagesId}"})
    private ProduitImages getProduitImages(@PathVariable("produitImagesId") int id) {
        return this.produitImagesService.getProduitImagesById(id);
    } */
    @PostMapping({"/produitImages/{produitId}"})
    @CrossOrigin(origins = "*")
    private ProduitImages saveproduitImages(@RequestBody ProduitImages produitImages, @PathVariable  int  produitId) {
        produitImages.setProduit(this.produitService.getProduitById(produitId));
        System.out.println(produitImages);
          this.produitImagesService.saveOrUpdate(produitImages); 
          return produitImages;
    }
    @PutMapping({"/produitImages"})
    @CrossOrigin(origins = "*")
    private ProduitImages updateroduitImages(@RequestBody ProduitImages produitImages) { 
          this.produitImagesService.saveOrUpdate(produitImages); 
          return produitImages;
    }
     @DeleteMapping({"/produitImages/{id}"})
    @CrossOrigin(origins = "*")
    private void deleteProduitImages( @PathVariable  int  id) { 
          this.produitImagesService.delete(id); 
    }
}
