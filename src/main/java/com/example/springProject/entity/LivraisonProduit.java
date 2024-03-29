package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table( schema = "livraison_produit")

@Getter @Setter
public class LivraisonProduit implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @ManyToOne
    @JoinColumn(name = "livraison_id")
    @JsonIgnoreProperties("LivraisonProduits")
    private Livraison livraison;

 


    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @Column
    private int quantiteLivraison;
    @Column
    private double prixLivraison;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateAffectation= Date.from(Instant.now()); 
  
    public String getDateAffectation() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (this.dateAffectation != null)
         return sdf.format(dateAffectation);
         return "";
        }
}
