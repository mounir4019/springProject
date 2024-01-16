package com.example.springProject.controllers;
 
import com.example.springProject.entity.User;
//import com.example.springProject.security.CustomUserDetailsService;
import com.example.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    UserService userService;
   /*  @Autowired
    CustomUserDetailsService customUserDetailsService;  */
    @GetMapping({"/users"})
    @CrossOrigin(origins = "*")
    private List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/user/{idUniq}"})
    @CrossOrigin(origins = "*")
    private /* UserDetails */User getUser( @PathVariable("idUniq") String idUniq) {
    //return customUserDetailsService.loadUserByUsername(idUniq);
        return  this.userService.getUserByIdUniq(idUniq);

    }
    @GetMapping({"/administration/getAllLivreurs"})
    @CrossOrigin(origins = "*")
    private List<User> getAllLivreurs( ) { 
        return  this.userService.getAllLivreurs();

    }
     @PostMapping({"/user"})
    @CrossOrigin(origins = "*")
    private /* UserDetails */User saveUser( @RequestBody User user) {
    //return customUserDetailsService.loadUserByUsername(idUniq);
        return  this.userService.saveOrUpdate(user);

    }
     @PutMapping({"/user"})
    @CrossOrigin(origins = "*")
    private /* UserDetails */User updateUser( @RequestBody User user) {
    //return customUserDetailsService.loadUserByUsername(idUniq);
        return  this.userService.saveOrUpdate(user);

    }
}
