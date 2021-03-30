package com.starwars.starwars.services;

import com.starwars.starwars.dto.PersonajeDTO;

import java.util.List;

public interface StarWarsService {
    List<PersonajeDTO> buscarPersonaje(String name);
}
