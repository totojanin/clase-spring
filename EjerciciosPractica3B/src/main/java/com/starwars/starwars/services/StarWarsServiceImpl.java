package com.starwars.starwars.services;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.repositories.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService {
    @Autowired
    private StarWarsRepository starWarsRepository;

    @Override
    public List<PersonajeDTO> buscarPersonaje(String name) {
        List<PersonajeDTO> personajes = new ArrayList<PersonajeDTO>();

        personajes = starWarsRepository.findPersonajeByName(name);

        return personajes;
    }
}
