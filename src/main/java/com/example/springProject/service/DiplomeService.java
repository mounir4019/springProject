package com.example.springProject.service;
import com.example.springProject.entity.Diplome;
import com.example.springProject.entity.Enseignant;
import com.example.springProject.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DiplomeService {
    @Autowired
    DiplomeRepository diplomeRepository  ;

    public List<Diplome> getAllDiplomes(Enseignant enseignant  ) {
        List<Diplome> diplomes = new ArrayList();
        diplomes.addAll(this.diplomeRepository.findAllByEnseignant(enseignant));
        return diplomes;
    }
    public Diplome getDiplomeById(int id) {
        return this.diplomeRepository.findById(id);
    }

    public void saveOrUpdate(Diplome diplome) {
        this.diplomeRepository.save(diplome);
    }

    public void delete(int id) {
        this.diplomeRepository.deleteById(id);
    }

    public void update(Diplome diplome, int id) {
        this.diplomeRepository.save(diplome);
    }
}
