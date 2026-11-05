package com.biblioteca.api.controllers;

import com.biblioteca.api.models.LibroTitulo;
import com.biblioteca.api.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroTitulo>> listarLibros() {
        return ResponseEntity.ok(libroService.obtenerTodosLosLibros());
    }

    @PostMapping
    public ResponseEntity<LibroTitulo> guardarLibro(@RequestBody LibroTitulo libro) {
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }
}