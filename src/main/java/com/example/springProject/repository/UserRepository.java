package com.example.springProject.repository;
import com.example.springProject.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface UserRepository extends PagingAndSortingRepository<User,Integer >, CrudRepository<User,Integer> {

    List<User> findAll();
    User findById(int id );
    User findByIdUniq(String idUniq);
    @Query("SELECT u FROM User u WHERE  u.type=1" )
    List<User> findAllLivreurs();
    
    <S extends User> S save(S User);
    void deleteByIdUniq(String idUniq);
    void deleteById(int id);

}