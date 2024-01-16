package com.example.springProject.repository; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.springProject.entity.Livraison;
import com.example.springProject.entity.LivraisonProduit;

import java.util.List;

public interface LivraisonProduitRepository extends PagingAndSortingRepository<LivraisonProduit, Integer>, CrudRepository<LivraisonProduit, Integer> {
    List<LivraisonProduit> findAll();

    LivraisonProduit findById(int id);
    <S extends LivraisonProduit> S save(S Livraison);
    void deleteById(int id);
}
