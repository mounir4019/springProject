package com.example.springProject.entity; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*; 
import java.io.Serializable; 
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "ProduitImages")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class ProduitImages implements Serializable{

    @Id
    @Column
    private int id;
     
    @Column
    private String  image64;
     
   // @ManyToOne(fetch = FetchType.LAZY)
    
   @JsonIgnoreProperties("produit") 
   @ManyToOne
   @JoinColumn(name = "produit_id")
   private Produit produit;
 

}
