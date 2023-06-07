package com.example.springProject.repository;

import com.example.springProject.entity.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface EnseignantRepository extends PagingAndSortingRepository<Enseignant, Integer>, CrudRepository<Enseignant, Integer> {
    List<Enseignant> findAll();

    Enseignant findById(int id);

    <S extends Enseignant> S save(S Enseignant);

    void deleteById(int id);
}