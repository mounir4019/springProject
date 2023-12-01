package com.example.springProject.controllers;

import com.example.springProject.entity.Categorie; 
import com.example.springProject.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @GetMapping({"/categories"})
    @CrossOrigin(origins = "*")
    private List<Categorie> getAllCategories() {
        return this.categorieService.getAllCategories();
    }

    @GetMapping({"/categories/{categorieId}"})
    private Categorie getCategorie(@PathVariable("categorieId") int id) {
        return this.categorieService.getCategorieById(id);
    }
}
