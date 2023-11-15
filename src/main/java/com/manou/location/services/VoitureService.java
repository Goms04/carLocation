package com.manou.location.services;

import com.manou.location.models.Voiture;
import com.manou.location.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    //update
    public Optional<Voiture> getVoiture(int id) {
        return voitureRepository.findById(id);
    }

    //read
    public Iterable<Voiture> getVoitures() {
        return voitureRepository.findAll();
    }

    //delete
    public void deleteVoiture(int id) {
        voitureRepository.deleteById(id);
    }

    //create
    public Voiture saveVoiture(Voiture voiture) {
        Voiture savedVoiture = voitureRepository.save(voiture);
        return savedVoiture;
    }
}
