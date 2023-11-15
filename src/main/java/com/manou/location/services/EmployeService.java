package com.manou.location.services;

import com.manou.location.models.Employe;
import com.manou.location.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    //update
    public Optional<Employe> getEmploye(int id) {
        return employeRepository.findById(id);
    }

    //read
    public Iterable<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    //delete
    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }

    //create
    public Employe saveEmploye(Employe employe) {
        Employe savedEmploye = employeRepository.save(employe);
        return savedEmploye;
    }
}
