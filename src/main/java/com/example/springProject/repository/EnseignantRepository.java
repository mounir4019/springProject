package com.example.springProject.repository;

import com.example.springProject.entity.Enseignant;
import com.example.springProject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;



public interface EnseignantRepository extends PagingAndSortingRepository<Enseignant, Integer>, CrudRepository<Enseignant, Integer> {
    List<Enseignant> findAll();

    Enseignant findById(int id);
    Enseignant findByUser(User user);

    <S extends Enseignant> S save(S Enseignant);

    void deleteById(int id);
}