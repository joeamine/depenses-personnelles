package com.joelearning.depenses_personnelles;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepenseService {
    private final DepenseRepository DR;

    public DepenseService(DepenseRepository DR) {
        this.DR = DR;
    }
    //methode lister
    public List<Depense> listerDepense(){
        return DR.findAll();
    }
    public Depense getDepense(Integer id){
        return DR.findById(id).orElse(null);
    }
    //methode ajouter
    public Depense AjouterDepense(Depense d){
        return DR.save(d);
    }
    //methode modifier
    public Depense mofifierDepense(Integer id,Depense d){
        Depense oldDepo=DR.findById(id).orElse(null);
        if(oldDepo != null){
            oldDepo.setCategorie(d.getCategorie());
            oldDepo.setMontant(d.getMontant());
            oldDepo.setDate(d.getDate());
            return DR.save(oldDepo);
        }
        return null;
    }
    //methode supprimer
    public String supprimerDepense(Integer id){
        DR.deleteById(id);
        return "le depense de id " +id+" est supprimer";
    }
//    //methode somme par categorie "avant spring data jpa"
//    public double sommeParCat(String catg){
//        double somme_cat=0;
//        for (Depense d : DR.findAll()){
//            if (d.getCategorie().equals(catg)){
//                somme_cat+=d.getMontant();
//            }
//
//        }
//        return somme_cat;
//    }
     public double sommeParCat(String catg){
        //Double pas double (cas de null)
         Double somme_cat=DR.sommeParCat(catg);
         if(somme_cat!=null){
             return somme_cat;
         }
         return 0;
     }
    public double sommeParMois(int mois){
        Double somme_mois=DR.sommeParMois(mois);
        if(somme_mois!=null){
            return somme_mois;
        }
        return 0;
    }
    public double sommeParMoisEtAns(int mois,int year){
        Double somme_mois_ans=DR.sommeParMoisEtAns(mois,year);
//plus bon
        return somme_mois_ans==null?0:somme_mois_ans;
    }
}
