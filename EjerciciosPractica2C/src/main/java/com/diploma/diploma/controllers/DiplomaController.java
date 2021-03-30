package com.diploma.diploma.controllers;

import com.diploma.diploma.entities.Alumno;
import com.diploma.diploma.entities.DiplomaDTO;
import com.diploma.diploma.services.DiplomaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {
    @PostMapping("/obtenerDiploma")
    public DiplomaDTO obtenerDiploma(@RequestBody Alumno alumno) {
        DiplomaDTO diplomaDTO = new DiplomaDTO();

        diplomaDTO.setAlumno(alumno);
        diplomaDTO.setPromedio(DiplomaService.calcularPromedio(alumno.getAsignaturas()));
        diplomaDTO.setMensaje(DiplomaService.getMensaje(diplomaDTO.getPromedio()));

        return diplomaDTO;
    }
}
