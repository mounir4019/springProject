package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "User")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class User implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String idUniq;
    @Column
    private String password;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String adresse;
    @Column
    private String email;
    @Column
    private String tel;
    @Column(columnDefinition = "LONGTEXT")
    private String  image64;
     @Column
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private  Date dateNaissance  ;
    @Column
    private int type;
    @Column
    private String roles;
    /*
    @OneToMany(mappedBy = "structure", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Enseignant> enseignants;
   */

    //  @OneToMany(mappedBy = "structure", cascade = CascadeType.ALL, orphanRemoval = true)
    //    @JsonIgnoreProperties(value = {"referenceList", "handler","hibernateLazyInitializer"}, allowSetters = true)

//    @JsonIgnoreProperties("structure")
//    @OneToMany(mappedBy = "structure",
//            cascade = CascadeType.PERSIST,
//            orphanRemoval = true)
   /*   @JoinColumn(name = "enseignant_id") 
     @JsonIgnoreProperties("user")
     @OneToOne(  )
    private   Enseignant   enseignant  ;
 */
/*
 * getRoles() return une chaine contient: ["ROLE_ADMIN","ROLE_STAT"]
 * l'objectid de getRole() est de retouner toutes le grant sous forme d'une chaine séparer par des espace(StringTokenizer) pour que je puisse utiliser dans:la classe CustomUserDetailsService
 * car elle contien une methode getGrantedAuthorities(user.getRole()) qui prends en paramettre une chaine.
 * voir getGrantedAuthorities
 */
public String getDateNaissance() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    if (this.dateNaissance != null)
     return sdf.format(dateNaissance);
     return "";
    }
 public String getRole(){
    // cette methode return une chaine contient tous les privilege separé par un espace entre eux
    String roles="";
    if(this.getRoles().length()>0){
    String rolesX= this.getRoles().substring(2, this.getRoles().length() - 2) ; 
    String[] rolesTab= rolesX.split("\",\"");
    for (int i=0;i<rolesTab.length;i++){
        roles= roles+" "+ rolesTab[i];
    }
    }
    
        return roles./* replace("ROLE_", "") */trim(); 
 }
}
