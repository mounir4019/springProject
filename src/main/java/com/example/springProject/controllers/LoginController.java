package com.example.springProject.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.entity.User;
@RestController 
@CrossOrigin(origins = "*") 
public class LoginController {

     @GetMapping("/demo/protected")
    public String helloSecure() {
        return "Hello Autour Du Code protected !";
    }

    @GetMapping("/demo/public")
    public String helloPublic() {
        return "Hello Autour Du Code public!";
    }

    @GetMapping("/demo/user")
    public String helloUser() {
        return "Hello Autour Du Code user!";
    }

    @GetMapping("/demo/admin")
    public String helloAdmin() {
        return "Hello Autour Du Code ADMIN!";
    }
 
}