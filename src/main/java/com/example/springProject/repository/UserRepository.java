package com.example.springProject.repository;
import com.example.springProject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface UserRepository extends PagingAndSortingRepository<User,Integer >, CrudRepository<User,Integer> {

    List<User> findAll();
    User findById(int id );
    User findByIdUniq(String idUniq);
    <S extends User> S save(S User);
    void deleteByIdUniq(String idUniq);
    void deleteById(int id);

}