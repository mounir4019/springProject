package com.example.springProject.entity; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*; 
import java.io.Serializable; 
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "Produit")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Produit implements Serializable{

    @Id
    @Column
    private int id;
    @Column
    private String designation;
    @Column
    private float prix=0;
    @Column
    private int nbStock=0;
    @Column
    private int nbTotVendu=0;
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "marque_id")
   @JsonIgnoreProperties("marques")
   @ManyToOne(  )
   private Marque marque  ;
 

}
