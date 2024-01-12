
package com.example.springProject.service; 
import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.repository.CommandeRepository; 
import com.example.springProject.repository.PanierRepository; 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class  CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    PanierRepository panierRepository;
    
    public CommandeService() {
    }
    public List<Commande> getAllCommandes() {
        List<Commande>  commandes = new ArrayList(); 
        commandes.addAll(this.commandeRepository.findAll());
        return  commandes;
    }
    
    public List<Commande> getMesCommandesClient(int idClient) {
        List<Commande>  commandes = new ArrayList(); 
        commandes.addAll(this.commandeRepository.findMesCommandesClient(idClient));
        return  commandes;
    }
    
    public  Commande getmaFactureClient(String ref  ) {
        return this.commandeRepository.findByRefFacture(ref  );
    }
    public  Commande getCommandeById(int id  ) {
        return this.commandeRepository.findById(id  );
    }
    public  Commande  getCommandeByPanier(int idPanier ) {
        Panier panier = this.panierRepository.findById(idPanier);
        return this.commandeRepository.findByPanier(panier );
    }
   @Transactional
    public Commande saveOrUpdate(Commande commande) {
        return this.commandeRepository.save(commande);
    }

    public void delete(int id ) {
        this.commandeRepository.deleteById(  id  );
    }

    public void update(Commande commande ) {
        this.commandeRepository.save(commande);
    } 
    public Commande validerCommande(  Commande commande){  
        return this.commandeRepository.save(commande);
    } 
}

