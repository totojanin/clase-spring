package com.metroscuadrados.metroscuadrados.entities;

import lombok.Data;

import java.util.List;

@Data
public class Casa {
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;
}
