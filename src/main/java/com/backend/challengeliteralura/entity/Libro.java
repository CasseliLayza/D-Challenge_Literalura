package com.backend.challengeliteralura.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIBROS")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String titulo;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "autor_id", nullable = false)// Clave foránea que referencia al autor
    private Autor autor;
    @Column(length = 10)
    private String idioma;
    private int numeroDescargas;


    public Libro(DatosLibro libroCoincidente) {
        this.titulo = libroCoincidente.titulo();
        DatosAutor DatosAutor = libroCoincidente.autores().get(0);
        this.autor = new Autor(DatosAutor);
        this.idioma = libroCoincidente.idiomas().get(0);
        this.numeroDescargas = libroCoincidente.numeroDescargas();
    }

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
