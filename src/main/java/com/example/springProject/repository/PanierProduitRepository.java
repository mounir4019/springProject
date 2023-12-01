package com.example.springProject.repository; 
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List; 

public interface PanierProduitRepository extends PagingAndSortingRepository<PanierProduit, Integer>, CrudRepository<PanierProduit, Integer> {
    List<PanierProduit> findAll();  
    PanierProduit  findById( int  id ); 
    List<PanierProduit> findByPanier ( Panier panier ); 
    <S extends PanierProduit> S saveAndFlush(S PanierProduit);
    <S extends PanierProduit> S save(S PanierProduit);
    void deleteById(int idPanier );
}