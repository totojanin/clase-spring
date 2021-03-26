package com.morse.morse.controllers;

import com.morse.morse.entities.Morse;
import com.morse.morse.services.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MorseController {
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/traducir/{codigoMorse}")
    public Morse traducir(@PathVariable String codigoMorse) {
        Morse cm = new Morse();

        cm.setIdentificador(contador.incrementAndGet());
        cm.setCodigoMorse(codigoMorse);
        cm.setTraduccion(MorseService.traducir(cm.getCodigoMorse()));

        return cm;
    }
}
