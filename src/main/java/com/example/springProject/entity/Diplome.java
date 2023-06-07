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
        schema = "Diplome"
)
@Getter @Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)

public class Diplome implements Serializable{
    @Id
    @Column
    private int id;
    @Column
    private String designation;
    @Column
    private String etablissementObtenu;

    @Column
    private String  image64;
    @Column
    private Date dateOptention;
    @JoinColumn(name = "type_diplome_id")
    @JsonIgnoreProperties("diplomes")
    @ManyToOne(  )
    private TypeDiplome typeDiplome  ;

    @JoinColumn(name = "enseignant_id")
    @JsonIgnoreProperties("diplomes")
    @ManyToOne(  )
    private Enseignant enseignant  ;


}
