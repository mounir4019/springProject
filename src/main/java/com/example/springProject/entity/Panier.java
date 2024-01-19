package com.example.springProject.entity; 
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
@Table( schema = "Produit")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Panier implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     @Column
    private  Date datePanier = Date.from(Instant.now());  
     
    @Column
    private int etat=0;
     @Column  (length = 20)
    private String userAnonymeId;
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   @JsonIgnoreProperties("paniers")
   @ManyToOne(  )
   private User user  ;
  // @JoinColumn(name = "panier_id")
  @JsonIgnoreProperties("panier")
  @OneToMany( mappedBy = "panier")
   private List< PanierProduit > panierProduits = new ArrayList<PanierProduit>(); 
    // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id")
    @JsonIgnoreProperties("commande")
    @OneToOne(  )
    private Commande commande  ; 
    
   public String getDatePanier() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(datePanier);
    }
    
}
