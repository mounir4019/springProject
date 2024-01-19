package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table( schema = "Livraison")

@Getter @Setter
public class Livraison implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnoreProperties("Livraisons")
    @ManyToOne ()
    @JoinColumn(name = "commande_id")
    private Commande commande;  
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // c'est le livreur == user.type=1
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateLivraison; // date de la livaison réelle du livreur au client
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateAffectation = Date.from(Instant.now());  // date d'affecter un livreur a une commande à livrer
    @Column
    private int etat=0;
    @Column (length = 20)
    private String referenceLivraison  ;
    //////// cas où on intriduit manuellement un livreur passager n'existe pas dans la base
    @Column
    private String nomLivreur;
    @Column
    private String prenomLivreur; 
    /// l'attribut ci apres entrepriseLivaison du livreur passager
    @ManyToOne()
    @JsonIgnoreProperties("entrepriseLivaisons")
    @JoinColumn(name = "entrepriseLivaison_id")
    private EntrepriseLivaison entrepriseLivaison;

    @OneToMany(mappedBy = "livraison" ) 
    @JsonIgnoreProperties("livraison")
   private List<LivraisonProduit> livraisonProduits = new ArrayList<LivraisonProduit>();   
   
    public String getDateLivraison() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    if (this.dateLivraison != null)
     return sdf.format(dateLivraison);
     return "";
    }
    public String getDateAffectation() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (this.dateAffectation != null)
         return sdf.format(dateAffectation);
         return "";
        }
}
