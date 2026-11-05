package com.biblioteca.api.repositories;

import com.biblioteca.api.models.CubiculoEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CubiculoEstudioRepository extends JpaRepository<CubiculoEstudio, Long> {
}