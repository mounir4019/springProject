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
    private  Date dateValidation;
    @Column
    private int etat = 0 ;
     @Column
    private String nom ;
     @Column
    private String prenom ;
    @Column
    private String adresseLivraison ;
    @Column
    private String tel ;
    @Column
    private String email ;
    @Column (length = 20)
    private String referenceFacture  ;
   // @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "panier_id")
   @JsonIgnoreProperties("commande")
   @OneToOne(  )
   private Panier panier  ; 
   
   public String getDate () {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date );
    }
    public String getDateValidation () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if( dateValidation ==null) 
          return "";
          return sdf.format(dateValidation );
        }
}
