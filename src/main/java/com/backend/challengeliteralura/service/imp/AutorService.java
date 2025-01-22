package com.backend.challengeliteralura.service.imp;

import com.backend.challengeliteralura.entity.Autor;
import com.backend.challengeliteralura.entity.AutorDTO;
import com.backend.challengeliteralura.repository.AutorRepository;
import com.backend.challengeliteralura.service.IAutorService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService implements IAutorService {

    private final Logger LOGGER = LoggerFactory.getLogger(LibroService.class);
    AutorRepository autorRepository;
    private ModelMapper modelMapper;

    public AutorService(AutorRepository autorRepository, ModelMapper modelMapper) {
        this.autorRepository = autorRepository;
        this.modelMapper = modelMapper;
        configureMapping();

    }


    @Override
    public Autor registrarAutor(Autor autor) {
        LOGGER.info("libro --> {}", autor);

        Autor autorRegistrado = autorRepository.save(autor);
        LOGGER.info("autorRegistrado --> {}", autorRegistrado);

        return autorRegistrado;
    }


    @Override
    @Transactional
    public List<AutorDTO> listarAutores() {

        List<AutorDTO> autoresRegistradosDTO = autorRepository.findAll().stream()
                .map(a -> modelMapper.map(a, AutorDTO.class))
                .collect(Collectors.toList());
        ;
        LOGGER.info("autoresRegistradosDTO --> {}", "\n\n" + autoresRegistradosDTO);
        return autoresRegistradosDTO;
    }


    @Override
    @Transactional
    public List<AutorDTO> listarAutoresVivosEnAno(int anoConsulta) {
        List<Autor> autores = autorRepository.findAll();

        return autores.stream()
                .filter(autor -> estaVivoEnAno(autor, anoConsulta))
                .map(a -> modelMapper.map(a, AutorDTO.class))
                .collect(Collectors.toList());
    }

    private boolean estaVivoEnAno(Autor autor, int anoConsulta) {

        Integer añoNacimiento = parseAno(autor.getAnioNacimiento());
        Integer añoFallecimiento = parseAno(autor.getAnioFallecimiento());

        if (añoFallecimiento == null) {
            return añoNacimiento != null && añoNacimiento <= anoConsulta;
        }

        return añoNacimiento != null && añoNacimiento <= anoConsulta &&
                añoFallecimiento >= anoConsulta;
    }

    private Integer parseAno(String ano) {
        try {
            return ano != null ? Integer.parseInt(ano) : null;
        } catch (Exception e) {
            return null;
        }
    }


    private void configureMapping() {

        modelMapper.typeMap(Autor.class, AutorDTO.class)
                .addMappings(mapper -> mapper.map(Autor::getLibros, AutorDTO::setLibros));

    }
}