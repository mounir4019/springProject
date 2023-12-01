package com.example.springProject.repository;

import com.example.springProject.entity.Categorie; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface CategorieRepository extends PagingAndSortingRepository<Categorie, Integer>, CrudRepository<Categorie, Integer> {
    List<Categorie> findAll(); 
    Categorie findById(int id);
    <S extends Categorie> S save(S Categorie);
    void deleteById(int id);
}