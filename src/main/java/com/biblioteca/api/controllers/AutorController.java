package com.biblioteca.api.controllers;

import com.biblioteca.api.models.Autor;
import com.biblioteca.api.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "*")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(autorService.obtenerTodosLosAutores());
    }

    @PostMapping
    public ResponseEntity<Autor> registrarAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.guardarAutor(autor));
    }
}