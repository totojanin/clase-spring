package com.calculadoracalorias.calculadoracalorias.repositories;

import com.calculadoracalorias.calculadoracalorias.dto.IngredienteCaloriasDTO;

public interface CalculadoraRepository {
    IngredienteCaloriasDTO findIngredienteByName(String name);
}
