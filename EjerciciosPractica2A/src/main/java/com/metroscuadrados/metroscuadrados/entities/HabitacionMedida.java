package com.metroscuadrados.metroscuadrados.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionMedida {
    private String nombre;
    private int cantidadMetrosCuadrados;
}
