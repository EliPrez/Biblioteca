package com.biblioteca.api.services;

import com.biblioteca.api.models.SocioLector;
import com.biblioteca.api.repositories.SocioLectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioService {

    @Autowired
    private SocioLectorRepository socioRepository;

    public List<SocioLector> obtenerTodosLosSocios() {
        return socioRepository.findAll();
    }

    public SocioLector registrarSocio(SocioLector socio) {
        return socioRepository.save(socio);
    }
}