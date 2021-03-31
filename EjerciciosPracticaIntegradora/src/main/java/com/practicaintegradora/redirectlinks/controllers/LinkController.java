package com.practicaintegradora.redirectlinks.controllers;

import com.practicaintegradora.redirectlinks.dto.ErrorDTO;
import com.practicaintegradora.redirectlinks.dto.InvalidateDTO;
import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.dto.MetricsDTO;
import com.practicaintegradora.redirectlinks.exceptions.InvalidLinkException;
import com.practicaintegradora.redirectlinks.exceptions.InvalidPasswordException;
import com.practicaintegradora.redirectlinks.exceptions.LinkNotFoundException;
import com.practicaintegradora.redirectlinks.services.LinkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/createLink")
    public ResponseEntity createLink(@RequestParam(value = "url") String url, @RequestParam(value = "password", defaultValue = "", required = false) String password) throws InvalidLinkException {
        LinkDTO linkDTO = linkService.createLink(url, password);

        return new ResponseEntity(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/link/{linkId}")
    public void createLink(@PathVariable Long linkId, @RequestParam(value = "password", defaultValue = "", required = false) String password, HttpServletResponse response) throws LinkNotFoundException, IOException, InvalidPasswordException {
        LinkDTO linkDTO = linkService.getLink(linkId, password);

        response.sendRedirect(linkDTO.getUrl());
    }

    @PostMapping("/metrics/{linkId}")
    public ResponseEntity createLink(@PathVariable Long linkId) throws LinkNotFoundException {
        MetricsDTO metricsDTO = linkService.getMetrics(linkId);

        return new ResponseEntity<MetricsDTO>(metricsDTO, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable Long linkId) throws LinkNotFoundException {
        InvalidateDTO invalidateDTO = linkService.invalidateLink(linkId);

        return new ResponseEntity<InvalidateDTO>(invalidateDTO, HttpStatus.OK);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity exceptionHandler(InvalidLinkException e) {
        return new ResponseEntity(new ErrorDTO("Link inválido", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity exceptionHandler(LinkNotFoundException e) {
        return new ResponseEntity(new ErrorDTO("Link no encontrado", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity exceptionHandler(InvalidPasswordException e) {
        return new ResponseEntity(new ErrorDTO("Password incorrecta", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
