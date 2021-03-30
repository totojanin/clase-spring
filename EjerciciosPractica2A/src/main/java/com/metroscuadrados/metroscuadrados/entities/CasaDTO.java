package com.metroscuadrados.metroscuadrados.entities;

import lombok.Data;

import java.util.List;

@Data
public class CasaDTO {
    private int cantidadTotalMetrosCuadrados;
    private int valorCasa;
    private Habitacion habitacionMasGrande;
    private List<HabitacionMedida> metrosCuadradosPorHabitacion;
}
