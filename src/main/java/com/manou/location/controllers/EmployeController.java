package com.manou.location.controllers;

import com.manou.location.models.Employe;
import com.manou.location.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeController {

    @GetMapping("/employes")
    public  String getEmploye(){
        return "pages/employe";
    }

    @Autowired
    private EmployeService employeService;

    //save
    @PostMapping("/employe")
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }

    //get employe by id
    @GetMapping("/employe/{id}")
    public Employe getEmploye(@PathVariable("id") int id) {
        Optional<Employe> employe = employeService.getEmploye(id);
        if(employe.isPresent()) {
            return employe.get();
        } else {
            return null;
        }
    }

    //read function
    @GetMapping("/employes")
    public Iterable<Employe> getEmployes() {
        return employeService.getEmployes();
    }

    //delete function
    @DeleteMapping("/employe/{id}")
    public void deleteEmploye(@PathVariable("id") int id) {
        employeService.deleteEmploye(id);
    }

    //update function
    @PutMapping("/employe/{id}")
    public Employe updateEmploye(@PathVariable("id") int id, @RequestBody Employe employe) {
        Optional<Employe> e = employeService.getEmploye(id);
        if(e.isPresent()) {
            Employe currentEmploye = e.get();

            String nom = employe.getNom();
            if(nom != null) {
                currentEmploye.setNom(nom);;
            }
            String prenom = employe.getPrenom();
            if(prenom != null) {
                currentEmploye.setPrenom(prenom);
            }
            String adresse = employe.getAdresse();
            if(adresse != null) {
                currentEmploye.setAdresse(adresse);;
            }
            Integer age = employe.getAge();
            if(age != null) {
                currentEmploye.setAge(age);;
            }
            String poste = employe.getPoste();
            if(poste != null) {
                currentEmploye.setPoste(poste);;
            }

            employeService.saveEmploye(currentEmploye);
            return currentEmploye;
        } else {
            return null;
        }
    }

}
