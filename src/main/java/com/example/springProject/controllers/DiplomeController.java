package com.example.springProject.controllers;

import com.example.springProject.entity.Diplome;
import com.example.springProject.entity.Enseignant;
import com.example.springProject.repository.EnseignantRepository;
import com.example.springProject.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class DiplomeController {
    @Autowired
    DiplomeService diplomeService  ;
    @Autowired
    EnseignantRepository enseignantRepository;
    Enseignant enseignant;
    @GetMapping({"enseignant/{idEns}/diplomes"})
    @CrossOrigin(origins = "*")
    private List<Diplome> getAllDiplomes(@PathVariable("idEns") int idEns) {

          enseignant = enseignantRepository.findById(idEns);
        return this.diplomeService.getAllDiplomes(enseignant);
    }

    @GetMapping({"/diplomes/{diplomeId}"})
    @CrossOrigin(origins = "*")
    private Diplome getDiplome(@PathVariable("diplomeId") int id) {
        return this.diplomeService.getDiplomeById(id);
    }
}
