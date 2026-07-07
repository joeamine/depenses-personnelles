package com.joelearning.depenses_personnelles;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Depense")
public class DepenseController {
    private final DepenseService DS;

    public DepenseController(DepenseService DS) {
        this.DS = DS;
    }
    //***********************GET*******************
    @GetMapping
    public List<Depense> getAllDepenses(){
        return DS.listerDepense();
    }
    @GetMapping("/{id}")
    public Depense getDepense(@PathVariable Integer id){
        return DS.getDepense(id);
    }
    //***********************POST****************
    @PostMapping
    public Depense ajouter(@RequestBody Depense d){
        return DS.AjouterDepense(d);
    }
    //*************************PUT*************
    @PutMapping("/{id}")
    public Depense modifier(@PathVariable Integer id,@RequestBody Depense d){
        return DS.mofifierDepense(id,d);
    }
    //**********************DELETE******************
    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable Integer id){
        return DS.supprimerDepense(id);
    }
    //********************ENDPOINT/statistique************
    @GetMapping("/total/categorie/{catg}")
    public double totalParCtegorie(@PathVariable String catg){
        return DS.sommeParCat(catg);
    }
    @GetMapping("/total/mois/{m}")
    public double totalDepenseParMois(@PathVariable int m){
        return DS.sommeParMois(m);
    }
    @GetMapping("/total/year/{y}/mois/{m}")
    public double totalDepenseParMoisEtAns(@PathVariable int m,@PathVariable int y){
        return DS.sommeParMoisEtAns(m,y);
    }

}
