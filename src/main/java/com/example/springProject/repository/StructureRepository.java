package com.example.springProject.repository;

import com.example.springProject.entity.Structure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;



public interface StructureRepository extends PagingAndSortingRepository<Structure, Integer>, CrudRepository<Structure, Integer> {
    List<Structure> findAll();
    List<Structure> findAllByTypeStructure(int typeStructure);
    Structure findById(int id);
    <S extends Structure> S save(S Structure);
    void deleteById(int id);
}