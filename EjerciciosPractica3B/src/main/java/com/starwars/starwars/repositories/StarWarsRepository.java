package com.starwars.starwars.repositories;

import com.starwars.starwars.dto.PersonajeDTO;

import java.util.List;

public interface StarWarsRepository {
    List<PersonajeDTO> findPersonajeByName(String name);
}
