package com.example.springProject.repository;
import com.example.springProject.entity.Diplome;
import com.example.springProject.entity.Enseignant;
import com.example.springProject.entity.TypeDiplome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
public interface DiplomeRepository extends PagingAndSortingRepository< Diplome, Integer>, CrudRepository< Diplome, Integer> {

    List< Diplome> findAll();
    List< Diplome> findAllByEnseignant(Enseignant enseignant);

     Diplome findById(int id);
    <S extends  Diplome> S save(S  Diplome);
    void deleteById(int id);
}