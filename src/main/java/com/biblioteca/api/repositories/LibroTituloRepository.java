package com.biblioteca.api.repositories;

import com.biblioteca.api.models.LibroTitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroTituloRepository extends JpaRepository<LibroTitulo, Long> {
}