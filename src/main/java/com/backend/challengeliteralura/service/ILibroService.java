package com.backend.challengeliteralura.service;

import com.backend.challengeliteralura.entity.Libro;
import com.backend.challengeliteralura.entity.LibroDTO;

import java.util.List;

public interface ILibroService {
    Libro registrarLibro(Libro libro);

    List<Libro> listarLibros();

    List<LibroDTO> listarLibrosPorIdioma(String idioma);


}
