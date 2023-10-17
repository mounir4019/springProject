package com.example.springProject.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(
        schema = "Enseignant"
)
@Getter @Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)

public class Enseignant implements Serializable{
    @Id
    @Column
    private int id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String tel;
    @Column
    private String cin;
     @Column
     private String  image64;
    @Column
    private Date dateNaissance;
    @Column
    private Date dateEntreeAdmin;

   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "structure_id")
   @JsonIgnoreProperties("enseignants")
   @ManyToOne(  )
   private Structure structure;
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("enseignants")
    @OneToOne(  )
    private User user;


//    @JsonIgnoreProperties("enseignant")
//    @OneToMany(mappedBy = "enseignant",
//            cascade = CascadeType.PERSIST,
//            orphanRemoval = true)
//    private List< Diplome > diplomes = new ArrayList<Diplome>();
}
