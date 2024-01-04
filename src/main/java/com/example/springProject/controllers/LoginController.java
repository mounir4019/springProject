package com.example.springProject.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springProject.entity.User;
import com.example.springProject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
   @Autowired
   AuthenticationManager authenticationManager;
    @Autowired
        UserService userService;
 
     
    @PostMapping("/api/login")
    public ResponseEntity<Map<String, String>> /* User */ login(@RequestBody User credentials) throws Exception {
       User user=userService.getUserByIdUniq(credentials.getIdUniq());
    System.out.println("credentials");
    
    System.out.println(credentials.getIdUniq()+credentials.getPassword());
    Authentication authenticationRequest =
			UsernamePasswordAuthenticationToken.unauthenticated(credentials.getIdUniq(), credentials.getPassword());
		
        Authentication authenticationResponse =
			this.authenticationManager.authenticate(authenticationRequest);
            System.out.println(authenticationResponse);
    /* if (isValidCredentials(credentials)) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Login successful");
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Invalid credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    } */
    
    Map<String, String> response = new HashMap<>();
    if(authenticationResponse.isAuthenticated())
    {
        response.put("status", "success");
        response.put("message", "Login successful"); 
        response.put("user", (new ObjectMapper()).writeValueAsString(user));
        System.out.println("mmmmmmmmmmmmm");System.out.println(user.getIdUniq());
        return ResponseEntity.ok(response);
    }
        else{ 
        response.put("status", "error");
        response.put("message", "Invalid credentials");
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }  
  }
 @PostMapping("/api/logout")
    public   ResponseEntity<Map<String, String>>  /* User */  logout(/* HttpServletRequest request, HttpServletResponse response, */@RequestBody User credentials) {
     User user=userService.getUserByIdUniq(credentials.getIdUniq()); 
     System.out.println("request"); System.out.println(user.getDateNaissance()); 
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       
      SecurityContextHolder.clearContext() ;// ceci le logout
      auth = SecurityContextHolder.getContext().getAuthentication(); //je verifie qu'il est bien deconnecte
    // SecurityContextHolder.getContext().setAuthentication(null);
      System.out.println("auth ap"); System.out.println(auth); 
      /*   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            return user;
        } */
        Map<String, String> response = new HashMap<>();
        
        if(auth!=null) {
          response.put("status", "error");
          response.put("message", "Logout failed");
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }else{
          response.put("status", "success");
          response.put("message", "Logout successful");
          return ResponseEntity.ok(response);
        }
         
    }
/*     private boolean isValidCredentials(Credentials credentials) {
        // Logique de vérification des informations d'identification
        // Vous devrez adapter cela à votre application
        return "2329025974".equals(credentials.getUsername()) && "admin".equals(credentials.getPassword());
    } */
 
} 