package com.biblioteca.api.repositories;

import com.biblioteca.api.models.SocioLector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioLectorRepository extends JpaRepository<SocioLector, Long> {
}