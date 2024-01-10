package com.example.springProject.repository; 
import com.example.springProject.entity.Panier;
import com.example.springProject.entity.PanierProduit;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List; 

public interface PanierProduitRepository extends PagingAndSortingRepository<PanierProduit, Integer>, CrudRepository<PanierProduit, Integer> {
    List<PanierProduit> findAll();  
    PanierProduit  findById( int  id ); 
    List<PanierProduit> findByPanier ( Panier panier ); 
    <S extends PanierProduit> S saveAndFlush(S PanierProduit);
    <S extends PanierProduit> S save(S PanierProduit);
    void deleteById(int idPanier );
    @Modifying
   @Query("DELETE FROM PanierProduit p WHERE p.panier.id = :idPanier and p.produit.id = :idProduit")
    void deleteByPanierProduit( @Param("idPanier") int idPanier, @Param("idProduit") int idProduit);
}