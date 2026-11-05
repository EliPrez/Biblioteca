package com.biblioteca.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "socios_lectores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocioLector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dpi_cui", nullable = false, unique = true, length = 20)
    private String dpiCui;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    private Boolean activo = true;
}