
package com.example.springProject.service; 
import com.example.springProject.entity.Marque ;
import com.example.springProject.entity.Produit; 
import com.example.springProject.repository.ProduitRepository;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

@Service
public class  ProduitService  {
    @Autowired
    ProduitRepository produitRepository;

    public ProduitService() {
    }
    public List<Produit> getAllProduits() {
        List<Produit>   produits = new ArrayList(); 
        produits.addAll(this.produitRepository.findAll());
        return  produits;
    }
    public Produit getProduitById(int id) {
        return this.produitRepository.findById(id);
    }
    public List<Produit> getProduitsByMarque(Marque marque) {
        return this.produitRepository.findByMarque(marque);
    }
     public List<Produit> getProduitsByCategoriePrix(int categorieId ,int prixMin,int prixMax ) {
         
        return produitRepository.findProduitsByCategoriePrix(categorieId,  prixMin,  prixMax);
    }
    public List<Produit> getProduitsByMarquePrix(int marqueId ,int prixMin,int prixMax ) {
         
        return produitRepository.findProduitsByMarquePrix(marqueId,  prixMin,  prixMax);
    }
    public List<Produit> getAllProduitsByPrix( int prixMin,int prixMax ) {
         
        return produitRepository.findProduitsByPrix( prixMin,  prixMax);
    }
     
    // public List<Produit> getProduitsByCategorie(Categorie categorie) {
    //     return this.produitRepository.findByCategorie(categorie);
    // }
    @Transactional
    public Produit saveOrUpdate(Produit produit) {
        return this.produitRepository.save(produit);
    }

    public void delete(int id) {
        this.produitRepository.deleteById(id);
    }

    public void update(Produit produit, int id) {
        this.produitRepository.save(produit) ;
    }


}

