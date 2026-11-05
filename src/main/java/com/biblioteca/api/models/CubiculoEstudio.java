package com.biblioteca.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cubiculos_estudio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CubiculoEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_cubiculo", nullable = false, length = 20)
    private String codigoCubiculo;

    @Column(nullable = false)
    private Integer capacidad;

    private Boolean disponible = true;
}