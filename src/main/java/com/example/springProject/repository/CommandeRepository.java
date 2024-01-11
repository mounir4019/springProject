package com.example.springProject.repository; 
import com.example.springProject.entity.Commande;
import com.example.springProject.entity.Panier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List; 

public interface CommandeRepository extends PagingAndSortingRepository<Commande, Integer>, CrudRepository<Commande, Integer> {
    List<Commande> findAll();  
    @Query("SELECT c FROM Commande c,Panier p WHERE  c.panier.id=p.id and p.user.id=:id" )
    List<Commande> findMesCommandesClient(int id);
    @Query("SELECT c FROM Commande c  WHERE  c.referenceFacture=:ref" )
    Commande findByRefFacture(String ref);
    Commande  findById( int  id ); 
    Commande  findByPanier ( Panier panier ); 
    <S extends Commande> S saveAndFlush(S Commande);
    <S extends Commande> S save(S Commande);
    void deleteById(int idCommande );
}