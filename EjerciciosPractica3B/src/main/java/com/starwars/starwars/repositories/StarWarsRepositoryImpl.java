package com.starwars.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {
    @Override
    public List<PersonajeDTO> findPersonajeByName(String name) {
        List<PersonajeDTO> personajes = loadDataBase();

        List<PersonajeDTO> result = new ArrayList<PersonajeDTO>();

        if (personajes != null) {
            result = personajes.stream()
                    .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return result;
    }

    private List<PersonajeDTO> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<List<PersonajeDTO>>() {};

        List<PersonajeDTO> personajes = null;

        try {
            personajes = objectMapper.readValue(file, typeRef);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return personajes;
    }
}
