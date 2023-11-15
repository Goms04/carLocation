package com.manou.location.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "clientid", insertable=false, updatable = false)
    private Client client;
    private int clientid;
    @ManyToOne
    @JoinColumn(name = "voitureid", insertable=false, updatable = false)
    private Voiture voiture;
    private Integer voitureid;
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private Date date_emprunt;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date_retour;
}
