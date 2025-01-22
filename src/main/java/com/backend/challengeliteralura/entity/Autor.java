package com.backend.challengeliteralura.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTORES")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String anioNacimiento;
    private String anioFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros;


    public Autor(DatosAutor autor) {
        this.nombre = autor.nombre();
        this.anioNacimiento = autor.anioNAcimiento();
        this.anioFallecimiento = autor.anioFallecimiento();

    }

    @Override
    public String toString() {
        // Obtener solo los títulos de los libros
        String librosTítulos = libros.stream()
                .map(Libro::getTitulo)  // Obtener solo el título de cada libro
                .collect(Collectors.joining(", "));  // Unir los títulos con una coma

        return
                "\n------AUTOR-----\n" +
                        " Autor: " + nombre + '\n' +
                        " Fecha de Nacimiento: " + anioNacimiento + '\n' +
                        " Fecha de Fallecimiento: " + anioFallecimiento + '\n' +
                        " Libros: " + librosTítulos + '\n' +  // Ahora solo imprime los títulos
                        "---------------\n";
    }
}