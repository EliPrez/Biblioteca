package com.biblioteca.api.services;

import com.biblioteca.api.models.Autor;
import com.biblioteca.api.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}