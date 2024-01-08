package com.example.springProject.controllers; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;
import com.example.springProject.repository.PanierProduitRepository;
import com.example.springProject.repository.PanierRepository;
import com.example.springProject.repository.ProduitRepository;
import com.example.springProject.service.PanierProduitService;
import com.example.springProject.service.PanierService;
import com.example.springProject.service.ProduitService;
import com.example.springProject.service.UserService;

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
    @Autowired
    UserService userService;
    @GetMapping({"/paniers"})
    @CrossOrigin(origins = "*")
    private List<Panier> getAllPaniers() {
        return this.panierService.getAllPaniers();
    }

    @GetMapping({"/paniers/{panierId}"})
    private Panier getPanier(@PathVariable("panierId") int id) {
        return this.panierService.getPanierById(id);
    }
     @GetMapping({"/paniers/user/{userId}"})
    private Panier getPanierByUserId(@PathVariable("userId") int id) {
        return this.panierService.getPanierByUserId(id);
    }
   @PostMapping("/paniers/{idUser}")
   @CrossOrigin(origins = "*")
   private  Panier  savePanier( @RequestBody Panier panier,@PathVariable("idUser") int id ) {  
         panier.setUser(userService.getUserById(id)); 
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
