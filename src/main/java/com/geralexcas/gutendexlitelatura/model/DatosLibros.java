package com.geralexcas.gutendexlitelatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(@JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<DatosAutor> autores,
                          @JsonAlias("languages") List<String> idiomas
                        ) {

}
