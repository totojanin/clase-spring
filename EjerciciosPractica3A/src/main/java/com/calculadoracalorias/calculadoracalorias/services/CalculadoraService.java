package com.calculadoracalorias.calculadoracalorias.services;

import com.calculadoracalorias.calculadoracalorias.dto.IngredienteCaloriasDTO;
import com.calculadoracalorias.calculadoracalorias.dto.IngredienteDTO;
import com.calculadoracalorias.calculadoracalorias.dto.PlatoDTO;
import com.calculadoracalorias.calculadoracalorias.dto.ResponseDTO;

import java.util.List;

public interface CalculadoraService {
    ResponseDTO crearResponsePlato(PlatoDTO plato);
    List<ResponseDTO> crearResponsePlatos(List<PlatoDTO> platos);
    int caloriasTotales(PlatoDTO plato);
    List<IngredienteCaloriasDTO> caloriasPorIngrediente(List<IngredienteDTO> ingredientes);
    IngredienteCaloriasDTO ingredienteMaxCalorias(List<IngredienteDTO> ingredientes);
}
