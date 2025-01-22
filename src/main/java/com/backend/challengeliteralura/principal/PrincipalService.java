package com.backend.challengeliteralura.principal;

import com.backend.challengeliteralura.entity.DatosBusqueda;
import com.backend.challengeliteralura.entity.DatosLibro;
import com.backend.challengeliteralura.entity.Libro;
import com.backend.challengeliteralura.service.ConsumoAPIService;
import com.backend.challengeliteralura.service.IAutorService;
import com.backend.challengeliteralura.service.ILibroService;
import com.backend.challengeliteralura.service.imp.ConvierteDatosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
public class PrincipalService {
    private final Logger LOGGER = LoggerFactory.getLogger(PrincipalService.class);
    private final String URL_BASE = "http://gutendex.com/books/?search=";
    private ConsumoAPIService consumoApiService = new ConsumoAPIService();
    private ConvierteDatosService conversor = new ConvierteDatosService();
    @Autowired
    @Lazy
    ILibroService libroService;
    @Autowired
    @Lazy
    IAutorService autorService;

    public void muestraMenu() {

        Scanner inputData = new Scanner(System.in);
        String inputText = "";
        Integer optionSelected = -1;

        while (optionSelected != 0) {
            printMenu();

            try {
                optionSelected = inputData.nextInt();
                inputData.nextLine();
            } catch (Exception e) {
                System.out.println("Ingrese un numero por favor!\n");
                inputData.nextLine();
                continue;
            }

            switch (optionSelected) {
                case 1 -> {

                    try {
                        System.out.println("Ingrese el nombre del libro que desea buscar!");
                        inputText = inputData.nextLine();
                    } catch (Exception e) {
                        System.out.println("Intente nuevamente. Ingresa una palabra!\n");
                        inputData.nextInt();
                        continue;
                    }
                    ObtenerDatosBusquedaPorTitulo(inputText);
                }
                case 2 -> {

                    libroService.listarLibros();
                }
                case 3 -> {
                    autorService.listarAutores();
                }

                case 4 -> {
                    try {
                        System.out.println("Ingrese el año vivo de autor(es) que desea buscar!");
                        inputText = inputData.nextLine();
                    } catch (Exception e) {
                        System.out.println("Intente nuevamente. Ingresa una palabra!\n");
                        inputData.nextInt();
                        continue;
                    }
                    System.out.println(autorService.listarAutoresVivosEnAno(Integer.parseInt(inputText)));
                }

                case 5 -> {

                    System.out.println("""
                            "Ingrese el año vivo de autor(es) que desea buscar!"
                            *********************
                            es) Español
                            en) Ingles
                            fr) Frances
                            pt) Portugues

                            *********************
                            """);
                    try {
                        inputText = inputData.nextLine();
                    } catch (Exception e) {
                        System.out.println("Intente nuevamente. Ingresa un idioma!\n");
                        inputData.nextInt();
                        continue;
                    }


                    System.out.println(libroService.listarLibrosPorIdioma(inputText));
                }

                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion incorrecta. Intente nuevamente.\n");
            }


        }
        inputData.close();
    }

    private void ObtenerDatosBusquedaPorTitulo(String inputText) {
        String json = consumoApiService.obtenerDatos(URL_BASE + inputText);
        System.out.println(json);

        DatosBusqueda datosBusqueda = conversor.obtenerDatos(json, DatosBusqueda.class);
        System.out.println(datosBusqueda);//

        System.out.println(datosBusqueda.libros().size());//


        List<DatosLibro> librosCoincidentes = datosBusqueda.libros().stream()
                .filter(libro -> libro.titulo().toLowerCase().contains(inputText.toLowerCase()))
                .collect(Collectors.toList());

        // storage
        registarLibroSeleccionado(librosCoincidentes);

    }

    private void registarLibroSeleccionado(List<DatosLibro> librosCoincidentes) {
        if (!librosCoincidentes.isEmpty()) {
            // aleatorio de las coincidencias
            Random random = new Random();
            DatosLibro libroCoincidenteAleatorio = librosCoincidentes.get(random.nextInt(librosCoincidentes.size()));
            LOGGER.info("libroCoincidenteAleatorio --> {}", libroCoincidenteAleatorio);

            Libro libroARegistar = new Libro(libroCoincidenteAleatorio);
            LOGGER.info("libroARegistar --> {}", libroARegistar);
            libroService.registrarLibro(libroARegistar);

        } else {
            System.out.println("No se encontró ningún libro que coincida con la palabra.");
        }
    }

    private static void printMenu() {
        System.out.println("""
                *****************************************************
                Sea bienbenido/a a Literalura =]
                                
                1) Buscar libro por titulo
                2) listar libros registrados
                3) Listar autores registrados
                4) listar autores vivos en un determinado año
                5) listar libros por idioma
                                
                0) salir
                =>> Elija una opcion valida
                                   
                *****************************************************
                """);
    }


}


