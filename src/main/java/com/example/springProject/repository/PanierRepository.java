package com.example.springProject.repository; 
import com.example.springProject.entity.Panier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List; 

public interface PanierRepository extends PagingAndSortingRepository<Panier, Integer>, CrudRepository<Panier, Integer> {
    List<Panier> findAll();  
    Panier findById(int id); 
    @Query("SELECT p FROM Panier p WHERE p.user.id = :id and p.etat=0")
    Panier findByUserId(int id); 
    @Query("SELECT p FROM Panier p WHERE p.userAnonymeId = :id and p.etat=0")
    Panier findByUserAnonymeId(String id); 
    <S extends Panier> S saveAndFlush(S panier);
    <S extends Panier> S save(S panier);
    void deleteById(int id);
}