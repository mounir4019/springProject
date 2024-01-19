package com.example.springProject.repository;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.springProject.entity.Livraison;

import java.util.List;

public interface LivraisonRepository extends PagingAndSortingRepository<Livraison, Integer>, CrudRepository<Livraison, Integer> {
    List<Livraison> findAll(); 
    Livraison findById(int id);
    @Query("SELECT l FROM Livraison l  WHERE  l.referenceLivraison=:ref" )
    Livraison findByRefLivraison(String ref  );
    
    @Query("SELECT l FROM Livraison l WHERE l.commande.id=:id")
    List<Livraison> findAllLivraisonByCmd(int id);  
    <S extends Livraison> S save(S Livraison);
    void deleteById(int id);
}
