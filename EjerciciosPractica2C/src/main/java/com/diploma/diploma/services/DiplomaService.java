package com.diploma.diploma.services;

import com.diploma.diploma.entities.Asignatura;

import java.util.List;

public class DiplomaService {
    private static double promedioHonor = 9;

    public static double calcularPromedio(List<Asignatura> asignaturas) {
        double promedio = 0;

        return asignaturas.stream().mapToInt(o -> o.getNota()).average().orElse(0);
    }

    public static String getMensaje(double promedio) {
        if (promedio >= promedioHonor)
            return "¡Felicitaciones por recibirte con honores!";

        return "El alumno se ha recibido satisfactoriamente";
    }
}
