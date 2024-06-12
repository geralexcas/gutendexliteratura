package com.geralexcas.gutendexlitelatura.repository;

import com.geralexcas.gutendexlitelatura.model.Autor;
import com.geralexcas.gutendexlitelatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Libro l JOIN l.autor a WHERE a.nombre LIKE %:nombre%")
    Optional<Autor> buscarAutorPorNombre(@Param("nombre") String nombre);

    @Query("SELECT l FROM Libro l JOIN l.autor a WHERE l.titulo LIKE %:titulo%")
    Optional<Libro> buscarLibroPorNombre(@Param("titulo") String titulo);

    @Query("SELECT l FROM Autor a JOIN a.libros l ORDER BY l.titulo")
    List<Libro> librosRegistrados();
    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND a.fechaDeFallecimiento > :fecha ")
    List<Autor> listarAutoresVivos(@Param("fecha")Integer fecha);

}
