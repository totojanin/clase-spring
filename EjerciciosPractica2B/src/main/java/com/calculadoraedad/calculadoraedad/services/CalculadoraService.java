package com.calculadoraedad.calculadoraedad.services;

import java.time.LocalDate;
import java.time.Period;

public class CalculadoraService {
    public static String calcularEdad(int dia, int mes, int anio) {
        Period edad;

        try {
            LocalDate date = LocalDate.of(anio, mes, dia);

            edad = Period.between(date, LocalDate.now());

            return edad.toString();
        }
        catch (Exception e) {
            return "0";
        }
    }
}
