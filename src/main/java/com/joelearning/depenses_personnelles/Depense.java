package com.joelearning.depenses_personnelles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Depense {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double montant;
    private String categorie;
    private LocalDate date;
    //localDate.of(yyyy,mm,dd)
     //Entity avoir 2 constructor vide et parametre
    public Depense() {
    }

    public Depense(double montant, String categorie, LocalDate date) {
        this.montant = montant;
        this.categorie = categorie;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
