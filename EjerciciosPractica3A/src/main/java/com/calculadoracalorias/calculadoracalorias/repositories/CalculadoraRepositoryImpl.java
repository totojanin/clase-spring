package com.calculadoracalorias.calculadoracalorias.repositories;

import com.calculadoracalorias.calculadoracalorias.dto.IngredienteCaloriasDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class CalculadoraRepositoryImpl implements CalculadoraRepository {

    @Override
    public IngredienteCaloriasDTO findIngredienteByName(String name) {
        List<IngredienteCaloriasDTO> ingredientesCalorias = loadDataBase();

        IngredienteCaloriasDTO result = null;

        if (ingredientesCalorias != null) {
            Optional<IngredienteCaloriasDTO> item = ingredientesCalorias.stream()
                    .filter(ingredienteCaloriasDTO -> ingredienteCaloriasDTO.getName().equals(name))
                    .findFirst();

            if (item.isPresent())
                result = item.get();
        }

        return result;
    }

    private List<IngredienteCaloriasDTO> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<IngredienteCaloriasDTO>> typeRef = new TypeReference<List<IngredienteCaloriasDTO>>() {};

        List<IngredienteCaloriasDTO> ingredienteCalorias = null;

        try {
            ingredienteCalorias = objectMapper.readValue(file, typeRef);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ingredienteCalorias;
    }
}
