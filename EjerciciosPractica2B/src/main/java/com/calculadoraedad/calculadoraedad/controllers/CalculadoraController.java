package com.calculadoraedad.calculadoraedad.controllers;

import com.calculadoraedad.calculadoraedad.services.CalculadoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return CalculadoraService.calcularEdad(dia, mes, anio);
    }
}
