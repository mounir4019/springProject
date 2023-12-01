package com.example.springProject.entity; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "Marque")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Marque implements Serializable{

    @Id
    @Column
    private int id;
    @Column
    private String designation;
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "categorie_id")
   @JsonIgnoreProperties("categories")
   @ManyToOne(  )
   private Categorie categorie  ;
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
