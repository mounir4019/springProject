package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
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
    private int id;
    @Column
    private String idUniq;
    @Column
    private String password;
    @Column
    private String email;
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
//    @JoinColumn(name = "user_id")
//    @JsonIgnoreProperties("enseignants")
//     @OneToOne(  )
//    private   Enseignant   enseignant  ;

}
