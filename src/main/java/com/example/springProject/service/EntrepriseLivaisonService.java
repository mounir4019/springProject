package com.example.springProject.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springProject.entity.EntrepriseLivaison; 
import com.example.springProject.repository.EntrepriseLivaisonRepository;

@Service
public class EntrepriseLivaisonService {
    @Autowired
    EntrepriseLivaisonRepository entrepriseLivaisonRepository;
    public List<EntrepriseLivaison> getAllEntrepriseLivaisons() {
        List<EntrepriseLivaison> entrepriseLivaisons = new ArrayList();
        entrepriseLivaisons.addAll(this.entrepriseLivaisonRepository.findAll());
        return entrepriseLivaisons;
    }
    public EntrepriseLivaison getEntrepriseLivaisonById(int id) {
        return this.entrepriseLivaisonRepository.findById(id);
    }
    
    public EntrepriseLivaison ajouterEntrepriseLivaison(EntrepriseLivaison entrepriseLivaison) {
        return this.entrepriseLivaisonRepository.save(entrepriseLivaison);
    }
    public EntrepriseLivaison modifierEntrepriseLivaison(EntrepriseLivaison entrepriseLivaison) {
        return this.entrepriseLivaisonRepository.save(entrepriseLivaison);
    }
    
}
