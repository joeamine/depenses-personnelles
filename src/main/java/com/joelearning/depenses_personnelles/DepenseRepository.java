package com.joelearning.depenses_personnelles;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {
    @Query("select SUM(d.montant) from Depense d where d.categorie=:catg")
    Double sommeParCat(@Param("catg") String catg);
//la somme par mois annes quelq
    @Query("select SUM(d.montant) from Depense d where month(d.date)=:m ")
    Double sommeParMois(@Param("m") int m);
   //amilioration
   @Query("select SUM(d.montant) from Depense d where month(d.date)=:m and year(d.date)=:y")
   Double sommeParMoisEtAns(@Param("m") int m,@Param("y") int y);
}
