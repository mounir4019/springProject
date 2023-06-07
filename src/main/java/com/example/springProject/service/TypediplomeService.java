package com.example.springProject.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springProject.entity.TypeDiplome;
import com.example.springProject.repository.TypeDiplomeRepository;

@Service
public class TypediplomeService {
    @Autowired
    TypeDiplomeRepository typeDiplomeRepository;
    public List<TypeDiplome> getAllTypeDiplomes() {
        List<TypeDiplome> typeDiplomes = new ArrayList();
        typeDiplomes.addAll(this.typeDiplomeRepository.findAll());
        return typeDiplomes;
    }
    public TypeDiplome getTypeDiplomeById(int id) {
        return this.typeDiplomeRepository.findById(id);
    }
}
