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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
   @Autowired
   AuthenticationManager authenticationManager;
    @Autowired
        UserService userService;
     @GetMapping("/demo/protected")
     @CrossOrigin(origins = "*")
    public String helloSecure() {
        return "Hello Autour Du Code protected !";
    }
    @CrossOrigin(origins = "*")
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
     
    @PostMapping("/api/login")
    public /* ResponseEntity<Map<String, String>> */ User login(@RequestBody User credentials) {
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
        System.out.println("mmmmmmmmmmmmm");System.out.println(user.getIdUniq());
        return user ;//ResponseEntity.ok(response);
    }
        else{ 
        response.put("status", "error");
        response.put("message", "Invalid credentials");
        return new User();//ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }  
  }
 @PostMapping("/api/logout")
    public /* ResponseEntity<String> */User  logout(/* HttpServletRequest request, HttpServletResponse response, */@RequestBody User credentials) {
               User user=userService.getUserByIdUniq(credentials.getIdUniq()); 
               System.out.println("request");//System.out.println(request);
       
    System.out.println(credentials.getIdUniq()+credentials.getPassword());
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     System.out.println("auth av"); System.out.println(auth.isAuthenticated());System.out.println(auth.getAuthorities()); 
      SecurityContextHolder.clearContext() ;
          auth = SecurityContextHolder.getContext().getAuthentication();
    // SecurityContextHolder.getContext().setAuthentication(null);
System.out.println("auth ap"); System.out.println(auth); 
      /*   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            return user;
        } */
        return  user;//ResponseEntity.ok("Logout successful");
    }
/*     private boolean isValidCredentials(Credentials credentials) {
        // Logique de vérification des informations d'identification
        // Vous devrez adapter cela à votre application
        return "2329025974".equals(credentials.getUsername()) && "admin".equals(credentials.getPassword());
    } */

   /*  static final class   Credentials {
        private String username;
        private String password;
      String  getUsername(){return username;}
       String getPassword(){return password;}
       void  setUsername(String username){  this.username=username ;}
       void setPassword(String password){  this.password=password;}
    } */
} 