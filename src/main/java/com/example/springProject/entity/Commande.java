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
@Table( schema = "commande")

@Getter @Setter
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Commande implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  Date date  = Date.from(Instant.now());  
     
    @Column
    private int etat ;
    @Column
    private String adresseLivraison ;
    
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "panier_id")
   @JsonIgnoreProperties("commande")
   @OneToOne(  )
   private Panier panier  ; 
   
   public String getDate () {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date );
    }
  
}
