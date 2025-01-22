package com.backend.challengeliteralura.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private Long id;
    private String titulo;
    private Autor autor;
    private String idioma;
    private int numeroDescargas;

    @Override
    public String toString() {
        return "\n------LIBRO-----\n" +
                " Titulo: " + titulo + '\n' +
                " Autor: " + autor.getNombre() + '\n' +
                " Idioma: " + idioma + '\n' +
                " Numero de descargas: " + numeroDescargas + '\n' +
                "---------------\n";
    }
}
