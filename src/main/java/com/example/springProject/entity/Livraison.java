package com.example.springProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat; 
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

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateLivraison;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date dateAffectation;
    @Column
    private String etat;

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
