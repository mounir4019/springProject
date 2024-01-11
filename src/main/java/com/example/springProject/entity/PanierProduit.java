package com.example.springProject.entity; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*; 
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant; 
import java.util.Date; 
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "produit_panier")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class PanierProduit implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     @Column
    private  Date date  = Date.from(Instant.now());  
     
    @Column
    private int quantite ;
    
    @Column
    private float prixFacture;
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "panier_id")
   @JsonIgnoreProperties("PanierProduits")
   @ManyToOne(  )
   private Panier panier  ;

  // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "produit_id")
   @JsonIgnoreProperties("PanierProduits")
   @ManyToOne(  )
   private Produit produit ;

   public String getDate () {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date );
    }
  
}
