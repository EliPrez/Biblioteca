package com.biblioteca.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libros_titulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroTitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(nullable = false, length = 200)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;
}