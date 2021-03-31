package com.calculadoracalorias.calculadoracalorias.controllers;

import com.calculadoracalorias.calculadoracalorias.dto.PlatoDTO;
import com.calculadoracalorias.calculadoracalorias.dto.ResponseDTO;
import com.calculadoracalorias.calculadoracalorias.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculadoraController {
    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/calcularCaloriasPlato")
    public ResponseDTO calcularCaloriasPlato(@RequestBody PlatoDTO plato) {
        return calculadoraService.crearResponsePlato(plato);
    }

    @PostMapping("/calcularCaloriasPlatos")
    public List<ResponseDTO> calcularCaloriasPlatos(@RequestBody List<PlatoDTO> platos) {
        return calculadoraService.crearResponsePlatos(platos);
    }
}
