
package com.example.springProject.service;
import com.example.springProject.entity.Categorie;
import com.example.springProject.entity.Marque ;
import com.example.springProject.repository.MarqueRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  MarqueService  {
    @Autowired
    MarqueRepository marqueRepository;

    public MarqueService() {
    }
    public List<Marque> getAllMarques() {
        List<Marque>  marques = new ArrayList(); 
        marques.addAll(this.marqueRepository.findAll());
        return  marques;
    }
    public Marque getMarqueById(int id) {
        return this.marqueRepository.findById(id);
    }
       public List<Marque> getMarquesByCategorie(Categorie categorie) {
        return this.marqueRepository.findByCategorie(categorie);
    }

    public void saveOrUpdate(Marque marque) {
        this.marqueRepository.save(marque);
    }

    public void delete(int id) {
        this.marqueRepository.deleteById(id);
    }

    public void update(Marque marque, int id) {
        this.marqueRepository.save(marque) ;
    }


}

