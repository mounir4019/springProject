package com.example.springProject.controllers;

import com.example.springProject.entity.EntrepriseLivaison; 
import com.example.springProject.service.EntrepriseLivaisonService;
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
public class EntrepriseLivaisonController {
    @Autowired
    EntrepriseLivaisonService entrepriseLivaisonService;
    @GetMapping({"/administration/entrepriseLivaisons"})
    private List<EntrepriseLivaison> getAllEntrepriseLivaison() {
        return this.entrepriseLivaisonService.getAllEntrepriseLivaisons();
    }

    @GetMapping({"/administration/entrepriseLivaisons/{entrepriseLivaisonId}"})
    private EntrepriseLivaison getEntrepriseLivaison(@PathVariable("entrepriseLivaisonId") int id) {
        return this.entrepriseLivaisonService.getEntrepriseLivaisonById(id);
    }
    @PostMapping({"/administration/entrepriseLivaisons"})
    private EntrepriseLivaison ajouterEntrepriseLivaison( @RequestBody EntrepriseLivaison entrepriseLivaison) {
        return this.entrepriseLivaisonService.ajouterEntrepriseLivaison(entrepriseLivaison);
    }
    @PutMapping({"/administration/entrepriseLivaisons"})
    private EntrepriseLivaison modifierEntrepriseLivaison(@PathVariable("entrepriseLivaisonId") int id,@RequestBody EntrepriseLivaison entrepriseLivaison) {
        return this.entrepriseLivaisonService.modifierEntrepriseLivaison (entrepriseLivaison);
    }
}
