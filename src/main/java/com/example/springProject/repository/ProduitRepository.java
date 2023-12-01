package com.example.springProject.repository;
  
import com.example.springProject.entity.Marque;
import com.example.springProject.entity.Produit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface ProduitRepository extends PagingAndSortingRepository<Produit, Integer>, CrudRepository<Produit, Integer> {
    List<Produit> findAll(); 
    List<Produit> findByMarque(Marque marque);
  // public List<Produit> findProduitsByCategorieId(int categorieId)  ;
   @Query("SELECT p FROM Produit p JOIN p.marque m WHERE m.categorie.id = :categoryId and p.prix >= :prixMin and p.prix <= :prixMax")
    List<Produit> findProduitsByCategoriePrix(int categoryId,int prixMin,int prixMax);

    @Query("SELECT p FROM Produit p WHERE p.marque.id = :marqueId                     and p.prix >= :prixMin and p.prix <= :prixMax")
    List<Produit> findProduitsByMarquePrix(int marqueId,int prixMin,int prixMax);
    
      @Query("SELECT p FROM Produit p WHERE    p.prix >= :prixMin and p.prix <= :prixMax")
    List<Produit> findProduitsByPrix(int prixMin,int prixMax);
    
     
    Produit findById(int id);
    <S extends Produit> S save(S Produit);
    void deleteById(int id);
}