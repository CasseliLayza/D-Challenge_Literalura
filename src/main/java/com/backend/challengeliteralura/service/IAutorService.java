package com.backend.challengeliteralura.service;

import com.backend.challengeliteralura.entity.Autor;
import com.backend.challengeliteralura.entity.AutorDTO;

import java.util.List;

public interface IAutorService {

    Autor registrarAutor(Autor autor);

    List<AutorDTO> listarAutores();

    List<AutorDTO> listarAutoresVivosEnAno(int anoConsulta);
}
