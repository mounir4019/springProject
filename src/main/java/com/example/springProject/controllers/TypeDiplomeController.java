package com.example.springProject.controllers;

import com.example.springProject.entity.TypeDiplome;
import com.example.springProject.service.TypediplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class TypeDiplomeController {
    @Autowired
    TypediplomeService typediplomeService;
    @GetMapping({"/typeDiplomes"})
    private List<TypeDiplome> getAllTypeDiplome() {
        return this.typediplomeService.getAllTypeDiplomes();
    }

    @GetMapping({"/typeDiplomes/{typeDiplomeId}"})
    private TypeDiplome getStructure(@PathVariable("typeDiplomeId") int id) {
        return this.typediplomeService.getTypeDiplomeById(id);
    }
}
