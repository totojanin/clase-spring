package com.metroscuadrados.metroscuadrados.controllers;

import com.metroscuadrados.metroscuadrados.entities.Casa;
import com.metroscuadrados.metroscuadrados.entities.CasaDTO;
import com.metroscuadrados.metroscuadrados.services.CasaService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CasaController {
    @PostMapping("/calcularMetrosCuadrados")
    public CasaDTO calcularMetrosCuadrados(@RequestBody Casa casa) {
        CasaDTO casaDTO = new CasaDTO();

        casaDTO.setCantidadTotalMetrosCuadrados(CasaService.calcularCantidadTotalMetrosCuadrados(casa));
        casaDTO.setValorCasa(CasaService.calcularValorCasa(casaDTO.getCantidadTotalMetrosCuadrados()));
        casaDTO.setHabitacionMasGrande(CasaService.habitacionMasGrande(casa));
        casaDTO.setMetrosCuadradosPorHabitacion(CasaService.calcularMetrosCuadradosPorHabitacion(casa));

        return casaDTO;
    }
}
