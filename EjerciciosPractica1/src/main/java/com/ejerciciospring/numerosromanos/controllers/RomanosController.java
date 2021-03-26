package com.ejerciciospring.numerosromanos.controllers;

import com.ejerciciospring.numerosromanos.entities.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RomanosController {
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/convertir/{numero}")
    public NumeroRomano convertir(@PathVariable int numero) {
        NumeroRomano nr = new NumeroRomano();

        nr.setIdentificador(contador.incrementAndGet());
        nr.setNumeroNatural(numero);
        nr.setNumeroRomano(nr.convertirANumeroRomano());

        return nr;
    }
}
