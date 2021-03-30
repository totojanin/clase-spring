package com.diploma.diploma.entities;

import lombok.Data;

@Data
public class DiplomaDTO {
    private String mensaje;
    private double promedio;
    private Alumno alumno;
}
