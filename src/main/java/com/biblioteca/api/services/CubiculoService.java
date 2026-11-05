package com.biblioteca.api.services;

import com.biblioteca.api.models.CubiculoEstudio;
import com.biblioteca.api.repositories.CubiculoEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CubiculoService {

    @Autowired
    private CubiculoEstudioRepository cubiculoRepository;

    public List<CubiculoEstudio> obtenerCubiculos() {
        return cubiculoRepository.findAll();
    }

    public CubiculoEstudio guardarCubiculo(CubiculoEstudio cubiculo) {
        return cubiculoRepository.save(cubiculo);
    }
}