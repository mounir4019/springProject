package com.example.springProject.controllers; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.repository.PanierProduitRepository;
import com.example.springProject.repository.PanierRepository;
import com.example.springProject.repository.ProduitRepository;
import com.example.springProject.service.PanierProduitService;
import com.example.springProject.service.PanierService;
import com.example.springProject.service.ProduitService;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class PanierController {
    @Autowired
    PanierProduitService panierProduitService;
    @Autowired
    PanierProduitRepository panierProduitRepository;
    @Autowired
    PanierService panierService;
    @Autowired
    PanierRepository panierRepository;

    @Autowired
    ProduitService produitService;
    @Autowired
    ProduitRepository produitRepository ;

    @GetMapping({"/panies"})
    @CrossOrigin(origins = "*")
    private List<Panier> getAllPaniers() {
        return this.panierService.getAllPaniers();
    }

    @GetMapping({"/paniers/{panierId}"})
    private Panier getPanier(@PathVariable("panierId") int id) {
        return this.panierService.getPanierById(id);
    }
   @PostMapping("/paniers")
   @CrossOrigin(origins = "*")
   private  Panier  savePanier( @RequestBody Panier panier) {   
     return  panierService.saveOrUpdate(panier); 
    }
    @GetMapping({"/paniersProduit/{panierId}"})
    private List<PanierProduit>  getPanierProduit(@PathVariable("panierId") int id) {
        return this.panierProduitService.getPanierProduitByPanier(id);
    }
@PostMapping("/paniers/panierProduit/{panierId}/{produitId}")
   @CrossOrigin(origins = "*")
   private  PanierProduit  savePanierProduit( @RequestBody PanierProduit panierProduit,@PathVariable("panierId") int panierId,@PathVariable("produitId") int produitId ) { 
      panierProduit.setPanier(panierService.getPanierById(panierId));
      panierProduit.setProduit(produitService.getProduitById(produitId));

     return  panierProduitService.saveOrUpdate(panierProduit); 
    }
}
