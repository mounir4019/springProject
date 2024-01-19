package com.example.springProject.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table( schema = "entreprise_livaison")
public class EntrepriseLivaison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String nom;
    private String adresse;
    @OneToMany(mappedBy = "entrepriseLivaison")
    @JsonIgnoreProperties("entrepriseLivaison")
   private List<Livraison> livraisons = new ArrayList<>();
}
