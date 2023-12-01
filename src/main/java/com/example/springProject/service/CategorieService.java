
package com.example.springProject.service;
import com.example.springProject.entity.Categorie;
import com.example.springProject.repository.CategorieRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public CategorieService() {
    }
    public List<Categorie> getAllCategories() {
        List<Categorie>  categories = new ArrayList(); 
        categories.addAll(this.categorieRepository.findAll());
        return  categories;
    }
    public Categorie getCategorieById(int id) {
        return this.categorieRepository.findById(id);
    }

    public void saveOrUpdate(Categorie categorie) {
        this.categorieRepository.save(categorie);
    }

    public void delete(int id) {
        this.categorieRepository.deleteById(id);
    }

    public void update(Categorie categorie, int id) {
        this.categorieRepository.save(categorie);
    }


}

