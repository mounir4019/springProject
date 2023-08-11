package com.example.springProject.controllers;

import com.example.springProject.entity.Enseignant;
import com.example.springProject.entity.User;
import com.example.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping({"/users"})
    @CrossOrigin(origins = "*")
    private List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/users/{idUniq}"})
    @CrossOrigin(origins = "*")
    private User getUser(@RequestBody User user,@PathVariable("idUniq") String idUniq) {
       return  this.userService.getUserByIdUniq(idUniq);

    }
}
