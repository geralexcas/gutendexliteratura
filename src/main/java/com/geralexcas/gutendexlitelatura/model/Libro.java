package com.geralexcas.gutendexlitelatura.model;

import jakarta.persistence.*;

import java.util.stream.Collectors;
//import com.geralexcas.gutendexlitelatura.model.DatosLibros;
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private String idioma;
    @ManyToOne()
    private Autor autor;


    public Libro(String titulo, String idioma, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}



