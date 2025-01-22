package com.backend.challengeliteralura.repository;

import com.backend.challengeliteralura.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findBytitulo(String titulo);

    List<Libro> findByIdioma(String idioma);
}
