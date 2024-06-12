package com.geralexcas.gutendexlitelatura.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
   // private Double numeroDeDescargas;
    @ManyToOne()
    private Autor autor;


    public Libro() {}

    public Libro(DatosLibros datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idioma = Idioma.fromString(datosLibro.idiomas().stream()
                .limit(1).collect(Collectors.joining()));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

  /*  public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    } */

   /* public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    } */

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "--------------- LIBRO ------------------" +
                "\nTítulo: " + titulo +
                "\nAutor: " + getAutor().getNombre() +
                "\nIdioma: " + idioma +

                "\n----------------------------------------\n";
    }
}
