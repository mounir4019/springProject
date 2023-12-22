package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "Categorie")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Categorie implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String designation;
     
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
//    private List< Enseignant > enseignants = new ArrayList<Enseignant>();

}
