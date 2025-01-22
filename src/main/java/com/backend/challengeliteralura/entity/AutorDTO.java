package com.backend.challengeliteralura.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private String nombre;
    private String anioNacimiento;
    private String anioFallecimiento;
    private List<LibroDTO> libros;

    @Override
    public String toString() {
        // Obtener solo los títulos de los libros
        String librosTítulos = libros.stream()
                .map(LibroDTO::getTitulo)  // Obtener solo el título de cada libro
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
