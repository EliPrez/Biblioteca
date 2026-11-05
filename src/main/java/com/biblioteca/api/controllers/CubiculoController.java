package com.biblioteca.api.controllers;

import com.biblioteca.api.models.CubiculoEstudio;
import com.biblioteca.api.services.CubiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cubiculos")
@CrossOrigin(origins = "*")
public class CubiculoController {

    @Autowired
    private CubiculoService cubiculoService;

    @GetMapping
    public ResponseEntity<List<CubiculoEstudio>> listarCubiculos() {
        return ResponseEntity.ok(cubiculoService.obtenerCubiculos());
    }

    @PostMapping
    public ResponseEntity<CubiculoEstudio> crearCubiculo(@RequestBody CubiculoEstudio cubiculo) {
        return ResponseEntity.ok(cubiculoService.guardarCubiculo(cubiculo));
    }
}