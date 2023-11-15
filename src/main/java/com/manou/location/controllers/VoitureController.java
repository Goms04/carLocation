package com.manou.location.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoitureController {

    @GetMapping("/voitures")
    public  String getVoiture(){
        return "pages/voiture";
    }
}
