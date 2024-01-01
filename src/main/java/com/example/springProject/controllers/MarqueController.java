package com.example.springProject.controllers; 
import com.example.springProject.entity.Categorie;
import com.example.springProject.entity.Marque;
import com.example.springProject.repository.CategorieRepository;
import com.example.springProject.service.CategorieService;
import com.example.springProject.service.MarqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarqueController { 
     @Autowired
    MarqueService marqueService;
     @Autowired
    CategorieService categorieService;
    @GetMapping({"/marques"})
    @CrossOrigin(origins = "*")
    private List<Marque> getAllMarques() {
        return this.marqueService.getAllMarques();
    }

    @GetMapping({"/marques/{categorieId}"})
    private List<Marque> getMarques(@PathVariable("categorieId") int id) {
        Categorie categorie = this.categorieService.getCategorieById(id);    
        return this.marqueService.getMarquesByCategorie(categorie);
    }
}
