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
}
