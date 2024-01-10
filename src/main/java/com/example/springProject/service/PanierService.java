
package com.example.springProject.service; 
import com.example.springProject.entity.Panier; 
import com.example.springProject.repository.PanierRepository; 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class  PanierService {
    @Autowired
    PanierRepository panierRepository;

    public PanierService() {
    }
    public List<Panier> getAllPaniers() {
        List<Panier>  paniers = new ArrayList(); 
        paniers.addAll(this.panierRepository.findAll());
        return  paniers;
    }
    public Panier getPanierById(int id) {
        return this.panierRepository.findById(id);
    }
     public Panier getPanierByUserId(int id) {
        return this.panierRepository.findByUserId(id);
    }
     public Panier getPanierByUserAnonymeId(String id) {
        return this.panierRepository.findByUserAnonymeId(id);
    }
    
    
   @Transactional
    public Panier saveOrUpdate(Panier panier) {
        return this.panierRepository.save(panier);
    }

    public void delete(int id) {
        this.panierRepository.deleteById(id);
    }

    public void update(Panier panier, int id) {
        this.panierRepository.save(panier);
    } 
}

