package com.starwars.starwars.controllers;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private StarWarsService starWarsService;

    @PostMapping("/calcularCaloriasPlato/{name}")
    public List<PersonajeDTO> calcularCaloriasPlato(@PathVariable String name) {
        return starWarsService.buscarPersonaje(name);
    }
}
