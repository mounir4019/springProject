package com.example.springProject.controllers;

import com.example.springProject.entity.Diplome;
import com.example.springProject.entity.Enseignant;
import com.example.springProject.repository.EnseignantRepository;
import com.example.springProject.repository.TypeDiplomeRepository;
import com.example.springProject.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class DiplomeController {
    @Autowired
    DiplomeService diplomeService  ;
    @Autowired
    TypeDiplomeRepository typeDiplomeRepository  ;

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
    @PostMapping({"/diplomes/{idEns}/{idtypedip}"})
    @CrossOrigin(origins = "*")
    private String addDiplome(@RequestBody Diplome diplome, @PathVariable("idEns") int idEns, @PathVariable("idtypedip") int idtypedip) {
        enseignant = enseignantRepository.findById(idEns);
        diplome.setEnseignant(enseignant);
        diplome.setTypeDiplome(typeDiplomeRepository.findById(idtypedip));
        this.diplomeService.saveOrUpdate(diplome);
        return   "diplome Ajouté avec succes" ;
    }
    @PutMapping({"/diplomes/{idtypedip}"})
    @CrossOrigin(origins = "*")
    private String updateDiplome(@RequestBody Diplome diplome,  @PathVariable("idtypedip") int idtypedip) {
        diplome.setTypeDiplome(typeDiplomeRepository.findById(idtypedip));
        this.diplomeService.saveOrUpdate(diplome);
        return   "diplome modifié avec succes" ;
    }
    @DeleteMapping  ({"/diplomes/{idDip}"})
    @CrossOrigin(origins = "*")
    private String deleteDiplome(  @PathVariable("idDip") int idDip) {
          this.diplomeService.delete(idDip);
        return   "diplome supprimé avec succes" ;
    }
}
