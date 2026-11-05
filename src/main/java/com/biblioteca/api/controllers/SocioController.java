package com.biblioteca.api.controllers;

import com.biblioteca.api.models.SocioLector;
import com.biblioteca.api.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
@CrossOrigin(origins = "*")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping
    public ResponseEntity<List<SocioLector>> listarSocios() {
        return ResponseEntity.ok(socioService.obtenerTodosLosSocios());
    }

    @PostMapping
    public ResponseEntity<SocioLector> registrarSocio(@RequestBody SocioLector socio) {
        return ResponseEntity.ok(socioService.registrarSocio(socio));
    }
}