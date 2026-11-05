package com.biblioteca.api.services;

import com.biblioteca.api.models.LibroTitulo;
import com.biblioteca.api.repositories.LibroTituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroTituloRepository libroRepository;

    // Método para listar todos los libros de la biblioteca
    public List<LibroTitulo> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    // Método para guardar un nuevo libro aplicando lógica o validaciones
    public LibroTitulo guardarLibro(LibroTitulo libro) {
        // Aquí podrías validar si el ISBN ya existe, por ejemplo.
        return libroRepository.save(libro);
    }
}