package com.example.springProject.repository;

import com.example.springProject.entity.TypeDiplome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface TypeDiplomeRepository extends PagingAndSortingRepository<TypeDiplome, Integer>, CrudRepository<TypeDiplome, Integer> {
    List<TypeDiplome> findAll();

    TypeDiplome findById(int id);
    <S extends TypeDiplome> S save(S TypeDiplome);
    void deleteById(int id);
}
