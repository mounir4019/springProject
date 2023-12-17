
package com.example.springProject.service;    
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springProject.entity.Produit;
import com.example.springProject.entity.ProduitImages;
import com.example.springProject.repository.ProduitImagesRepository;

@Service
public class  ProduitImagesService   {
    @Autowired
    ProduitImagesRepository produitImagesRepository;

    
    public List<ProduitImages> getAllProduitImages() {
        List<ProduitImages>   produitImages = new ArrayList(); 
        produitImages.addAll(this.produitImagesRepository.findAll());
        return  produitImages;
    }
    public List<ProduitImages> getProduitImagesByProduit(Produit produit) {
        List<ProduitImages>   produitImages = new ArrayList(); 
        produitImages.addAll(this.produitImagesRepository.findAllByProduit(produit));
        return  produitImages;
    }
    public ProduitImages getProduitImagesById(int id) {
        return this.produitImagesRepository.findById(id);
    } 
    @Transactional
    public ProduitImages saveOrUpdate(ProduitImages produitImages) {
        return this.produitImagesRepository.save(produitImages);
    }

    public void delete(int id) {
        this.produitImagesRepository.deleteById(id);
    }

    public void update(ProduitImages produitImages, int id) {
        this.produitImagesRepository.save(produitImages) ;
    }


}

