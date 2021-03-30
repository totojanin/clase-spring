package com.diploma.diploma.entities;

import lombok.Data;

import java.util.List;

@Data
public class Alumno {
    private String nombre;
    private List<Asignatura> asignaturas;
}
