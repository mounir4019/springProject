package com.example.springProject.repository;

import com.example.springProject.entity.EntrepriseLivaison;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface EntrepriseLivaisonRepository extends PagingAndSortingRepository<EntrepriseLivaison, Integer>, CrudRepository<EntrepriseLivaison, Integer> {
    List<EntrepriseLivaison> findAll(); 
    EntrepriseLivaison findById(int id);
    <S extends EntrepriseLivaison> S save(S EntrepriseLivaison);
    void deleteById(int id);
}
