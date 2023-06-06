package com.example.springProject.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "structure_id")
    @JsonIgnoreProperties("enseignants")
    //@ManyToOne(cascade = CascadeType.ALL )
    @ManyToOne(  )
    private Structure structure;
}
