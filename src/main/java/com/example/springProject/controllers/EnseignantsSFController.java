package com.example.springProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.entity.Enseignant;
import com.example.springProject.service.EnseignantService;

@Controller
@RequestMapping  ("/web") 
// @RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class EnseignantsSFController { 
    @Autowired
    EnseignantService enseignantService;     
  
    @GetMapping  ("/listenseignants") 
    public String listEnseignants(Model model) {
        List<Enseignant> enseignants = this.enseignantService.getAllEnseignants();
        model.addAttribute("message", "Hello Thymeleaf!");
        model.addAttribute("enseignants", enseignants);
        return "listenseignants"; // Retourne le nom du template Thymeleaf sans l'extension .html
    }
     @GetMapping({"/enseignant/{enseignantId}"})
    private String getEnseignant(Model model, @PathVariable("enseignantId") int id) {
         Enseignant enseignant = this.enseignantService.getEnseignantById(id);         
          model.addAttribute("enseignant", enseignant);
        return "enseignantDetails"; 
    }
    
   @PostMapping({"/updateEnseignant/{enseignantId}"})
    private String updateEnseignant(@ModelAttribute("enseignant") Enseignant enseignant ,@PathVariable("enseignantId") int id) {
        
        System.out.print(enseignant.getId()+enseignant.getNom()+enseignant.getTel()); 
        enseignant.setId(id);
          this.enseignantService.saveOrUpdate(enseignant); 
        return "redirect:/web/listenseignants"; 
    }
     @GetMapping({"/enseignant/add"})
    private String getEnseignant(Model model ) {
         Enseignant enseignant = new Enseignant();         
          model.addAttribute("enseignant", enseignant);
        return "addEnseignant"; 
    }
    @PostMapping({"/addEnseignant"})
    private String addEnseignant(@ModelAttribute("enseignant") Enseignant enseignant) {
        
        System.out.println("enseignant" );
        System.out.println( enseignant.getId()+enseignant.getNom());
          this.enseignantService.saveOrUpdate(enseignant); 
        return "redirect:/web/listenseignants"; 
    }
    // Autres méthodes et fonctionnalités
}
 