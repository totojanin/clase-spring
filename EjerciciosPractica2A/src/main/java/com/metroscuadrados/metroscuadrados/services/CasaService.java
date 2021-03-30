package com.metroscuadrados.metroscuadrados.services;

import com.metroscuadrados.metroscuadrados.entities.Casa;
import com.metroscuadrados.metroscuadrados.entities.Habitacion;
import com.metroscuadrados.metroscuadrados.entities.HabitacionMedida;

import java.util.ArrayList;
import java.util.List;

public class CasaService {
    private static int precioPorMetroCuadrado = 800;

    public static int calcularCantidadTotalMetrosCuadrados(Casa casa) {
        int metrosCuadrados = 0;

        metrosCuadrados = calcularMetrosCuadradosPorHabitacion(casa).stream().mapToInt(o -> o.getCantidadMetrosCuadrados()).sum();

        return metrosCuadrados;
    }

    public static int calcularValorCasa(int cantidadMetrosCuadrados) {
        return cantidadMetrosCuadrados * precioPorMetroCuadrado;
    }

    public static Habitacion habitacionMasGrande(Casa casa) {
        int maxCantidadMetrosCuadradosHabitacion = -1;

        Habitacion habitacionMasGrande = new Habitacion();

        for (Habitacion habitacion : casa.getHabitaciones()) {
            int metrosCuadradosHabitacion = calcularMetrosCuadradosHabitacion(habitacion);

            if (metrosCuadradosHabitacion > maxCantidadMetrosCuadradosHabitacion) {
                maxCantidadMetrosCuadradosHabitacion = metrosCuadradosHabitacion;

                habitacionMasGrande = habitacion;
            }
        }

        return habitacionMasGrande;
    }

    public static List<HabitacionMedida> calcularMetrosCuadradosPorHabitacion(Casa casa) {
        List<HabitacionMedida> metrosCuadradosPorHabitacion = new ArrayList<HabitacionMedida>();

        for (Habitacion habitacion : casa.getHabitaciones()) {
            metrosCuadradosPorHabitacion.add(new HabitacionMedida(habitacion.getNombre(), calcularMetrosCuadradosHabitacion(habitacion)));
        }

        return metrosCuadradosPorHabitacion;
    }

    private static int calcularMetrosCuadradosHabitacion(Habitacion habitacion) {
        return habitacion.getAncho() * habitacion.getLargo();
    }
}
