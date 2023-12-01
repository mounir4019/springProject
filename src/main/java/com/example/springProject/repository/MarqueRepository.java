package com.example.springProject.repository;

import com.example.springProject.entity.Categorie;
import com.example.springProject.entity.Marque; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface MarqueRepository extends PagingAndSortingRepository<Marque, Integer>, CrudRepository<Marque, Integer> {
    List<Marque> findAll(); 
    List<Marque> findByCategorie(Categorie categorie); 
    Marque findById(int id);
    <S extends Marque> S save(S Marque);
    void deleteById(int id);
}