package com.example.springProject.repository; 
import com.example.springProject.entity.Panier;  
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List; 

public interface PanierRepository extends PagingAndSortingRepository<Panier, Integer>, CrudRepository<Panier, Integer> {
    List<Panier> findAll();  
    Panier findById(int id); 
    <S extends Panier> S saveAndFlush(S panier);
    <S extends Panier> S save(S panier);
    void deleteById(int id);
}