package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "Type_Diplome")

@Getter @Setter
public class TypeDiplome implements Serializable{
    @Id
    @Column
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private String designation;
//    @JsonIgnoreProperties("typeDiplome")
//    @OneToMany(mappedBy = "typeDiplome",
//            cascade = CascadeType.PERSIST,
//            orphanRemoval = true)
//    private List< Diplome > diplomes = new ArrayList<Diplome>();
}
