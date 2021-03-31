package com.practicaintegradora.redirectlinks.controllers;

import com.practicaintegradora.redirectlinks.dto.LinkDTO;
import com.practicaintegradora.redirectlinks.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/createLink/{url}")
    public ResponseEntity<AtomicLong> createLink(@PathVariable String url) {
        return new ResponseEntity<>(linkService.createLink(url), HttpStatus.OK);
    }
}
