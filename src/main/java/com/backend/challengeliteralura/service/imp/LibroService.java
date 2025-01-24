package com.backend.challengeliteralura.service.imp;

import com.backend.challengeliteralura.entity.Libro;
import com.backend.challengeliteralura.entity.LibroDTO;
import com.backend.challengeliteralura.repository.LibroRepository;
import com.backend.challengeliteralura.service.ILibroService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService implements ILibroService {
    private final Logger LOGGER = LoggerFactory.getLogger(LibroService.class);

    private LibroRepository libroRepository;
    private ModelMapper modelMapper;

    public LibroService(@Autowired LibroRepository libroRepository, ModelMapper modelMapper) {
        this.libroRepository = libroRepository;
        this.modelMapper = modelMapper;
        //configureMapping();
    }

    @Override
    public Libro registrarLibro(Libro libro) {
        //LOGGER.info("libro --> {}", libro);

        Libro LibroBuscado = libroRepository.findBytitulo(libro.getTitulo());
        Libro libroRegistrado = null;
        if (LibroBuscado != null) {
            LOGGER.error("No fue posible registrar el Libro porque ya existe en el sistema!!");

        } else {
            libroRegistrado = libroRepository.save(libro);
            LOGGER.info("libroRegistrado --> {}", libroRegistrado);
        }

        return libroRegistrado;

    }

    @Override
    @Transactional
    public List<Libro> listarLibros() {

        List<Libro> librosRegistrados = libroRepository.findAll();
        LOGGER.info("librosRegistrados --> {}", "\n\n" + librosRegistrados);
        return librosRegistrados;
    }

    @Override
    @Transactional
    public List<LibroDTO> listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepository.findByIdioma(idioma);

        return libros.stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());
    }
}
