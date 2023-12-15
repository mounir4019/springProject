package com.example.springProject.repository; 
import com.example.springProject.entity.ProduitImages; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List; 

public interface ProduitImagesRepository extends PagingAndSortingRepository<ProduitImages, Integer>, CrudRepository<ProduitImages, Integer> {
    List<ProduitImages> findAll();  
    ProduitImages findById(int id);
    <S extends ProduitImages> S save(S ProduitImages);
    void deleteById(int id);
}