package com.calculadoracalorias.calculadoracalorias.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private int caloriasTotalPlato;
    private List<IngredienteCaloriasDTO> caloriasPorIngrediente;
    private IngredienteCaloriasDTO ingredienteMaxCalorias;
}
