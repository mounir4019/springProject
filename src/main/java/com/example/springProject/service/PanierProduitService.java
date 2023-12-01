
package com.example.springProject.service; 
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.repository.PanierProduitRepository;
import com.example.springProject.repository.PanierRepository; 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class  PanierProduitService {
    @Autowired
    PanierProduitRepository panierProduitRepository;
    @Autowired
    PanierRepository panierRepository;
    public PanierProduitService() {
    }
    public List<PanierProduit> getAllPaniers() {
        List<PanierProduit>  panierProduits = new ArrayList(); 
        panierProduits.addAll(this.panierProduitRepository.findAll());
        return  panierProduits;
    }
    public  PanierProduit getPanierProduitById(int id  ) {
        return this.panierProduitRepository.findById(id  );
    }
    public List<PanierProduit> getPanierProduitByPanier(int idPanier ) {
    Panier panier = this.panierRepository.findById(idPanier);
        return this.panierProduitRepository.findByPanier(panier );
    }
   @Transactional
    public PanierProduit saveOrUpdate(PanierProduit panierProduit) {
        return this.panierProduitRepository.save(panierProduit);
    }

    public void delete(int idPanier,int idProduit) {
        this.panierProduitRepository.deleteById(  idPanier );
    }

    public void update(PanierProduit panierProduit ) {
        this.panierProduitRepository.save(panierProduit);
    } 
}

