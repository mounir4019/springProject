
package com.example.springProject.service;

import com.example.springProject.entity.User;
import com.example.springProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService() {
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        users.addAll(this.userRepository.findAll());
        return users;
    }
    public User getUserByIdUniq(String idUniq) {
        return this.userRepository.findByIdUniq(idUniq) ;
    }

    public void saveOrUpdate(User user) {
        this.userRepository.save(user);
    }

    public void delete(String idUniq) {
        this.userRepository.deleteByIdUniq(idUniq);
    }

    public void update(User user, String idUniq) {
        this.userRepository.save(user);
    }


}

